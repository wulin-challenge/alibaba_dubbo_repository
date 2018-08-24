package cn.wulin.dubbo.demo.api.consumer;

import java.io.IOException;

public class TestRunTime {
	
	public static void main(String[] args) {
		
	       Runtime.
	        getRuntime().//返回与当前 Java 应用程序相关的运行时对象。
	        //注册新的虚拟机来关闭钩子。 
	        addShutdownHook(new Thread(new Runnable() {
	            public void run() {
	            	System.out.println("我是关闭回调");
	            }
	        }, "DubboShutdownHook"));
	       
	       System.out.println("xxxx");
	       try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
