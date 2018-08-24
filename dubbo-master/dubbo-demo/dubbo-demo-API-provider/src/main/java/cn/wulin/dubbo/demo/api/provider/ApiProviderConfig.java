package cn.wulin.dubbo.demo.api.provider;

import java.io.IOException;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.alibaba.dubbo.demo.DemoService;

public class ApiProviderConfig {
	
	public static void main(String[] args) {
		ApiProviderConfig apiProviderConfig = new ApiProviderConfig();
		apiProviderConfig.apiConfig();
		
	}
	
	private void apiConfig(){
		DemoService providerApi = new ApiDemoServiceImpl();
		
		// 当前应用配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName("api-provider-config");
		
		// 连接注册中心配置
		RegistryConfig registry = new RegistryConfig();
		registry.setProtocol("zookeeper");
		registry.setAddress("192.168.0.2:2181");
//		registry.setAddress("zxq:2181");
		
		// 服务提供者协议配置
		ProtocolConfig protocol = new ProtocolConfig();
		protocol.setName("dubbo");
		
		ApiDemoServiceImpl.port = 12345;
		protocol.setPort(ApiDemoServiceImpl.port);
		protocol.setThreads(200);
		
		// 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口
		 
		// 服务提供者暴露服务配置
		ServiceConfig<DemoService> service = new ServiceConfig<DemoService>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
		service.setApplication(application);
		service.setRegistry(registry); // 多个注册中心可以用setRegistries()
		service.setProtocol(protocol); // 多个协议可以用setProtocols()
		service.setInterface(DemoService.class);
		service.setRef(providerApi);
		service.setVersion("1.0.0");
		 
		// 暴露及注册服务
		service.export();
		System.out.println("启动成功!!");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
