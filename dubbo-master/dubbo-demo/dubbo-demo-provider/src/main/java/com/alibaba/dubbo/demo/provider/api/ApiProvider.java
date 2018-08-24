package com.alibaba.dubbo.demo.provider.api;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.config.ApplicationConfig;

/**
 * Created by ken.lj on 2017/7/31.
 */
public class ApiProvider {
	


    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-provider.xml"});
        context.start();
        
//        ExtensionLoader<ApplicationConfig>.getExtensionLoader(ApplicationConfig.class);
        
//        ApplicationConfig adaptiveExtension = ExtensionLoader.getExtensionLoader(ApplicationConfig.class).getAdaptiveExtension();
//        
//        ReferenceConfig
        
        
//        ApplicationConfig bean = context.getBean("applicationConfig", ApplicationConfig.class);
        System.out.println();
        
        
        
////        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
////        String hello = demoService.sayHello("world"); // 执行远程方法
//        BeanDefinition bean = new GenericBeanDefinition();
//        //类的全路径
//      bean.setBeanClassName("com.xh.spring.bean.Dog");
////      
//      DefaultListableBeanFactory fty = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
//////      //注册Bean
//      fty.registerBeanDefinition("dog101", bean);
//        
        System.in.read(); // 按任意键退出
    }

}
