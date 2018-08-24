package cn.wulin.dubbo.demo.api.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.demo.DemoService;

public class ApiConsumerConfig {
	
	public static void main(String[] args) {
		ApiConsumerConfig apiConsumerConfig =new ApiConsumerConfig();
		apiConsumerConfig.apiConfig();
	}
	
	private void apiConfig(){
		// 当前应用配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName("dubbo-demo-api-consumer");
		
		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setProtocol("zookeeper");
		registry.setAddress("192.168.0.2:2181");
//		registry.setAddress("zxq:2181");
		
		// 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接
		 
		// 引用远程服务
		ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
		reference.setApplication(application);
		reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
		reference.setInterface(DemoService.class);
		reference.setVersion("1.0.0");
		 
		// 和本地bean一样使用xxxService
		DemoService demoService = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
		
		for (int i = 0; i < 100000; i++) {
			String sayHello = demoService.sayHello("wubo");
			System.out.println(sayHello);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
