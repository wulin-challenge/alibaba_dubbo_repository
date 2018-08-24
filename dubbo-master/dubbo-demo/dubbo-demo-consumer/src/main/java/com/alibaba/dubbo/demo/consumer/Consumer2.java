package com.alibaba.dubbo.demo.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.demo.DemoService;

/**
 * Created by ken.lj on 2017/7/31.
 */
public class Consumer2 {

    public static void main(String[] args) {
    	// 当前应用配置
    	ApplicationConfig application = new ApplicationConfig();
    	application.setName("demo1-application");
    	
    	
    	// 连接注册中心配置
    	RegistryConfig registry = new RegistryConfig();
    	registry.setAddress("zxq:2181");
    	registry.setProtocol("zookeeper");

    	
    	// 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

    	// 引用远程服务
    	ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
    	reference.setApplication(application);
    	reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
    	reference.setInterface(DemoService.class);
    	
    	DemoService demoService = reference.get();
    	String sayHello = demoService.sayHello("dubbo:你好!");
    	System.out.println(sayHello);
    	System.out.println();
    }
}
