package cn.wulin.dubbo.demo.api.provider;

import com.alibaba.dubbo.demo.DemoService;


public class ApiDemoServiceImpl implements DemoService{
	public static int port;

	@Override
	public String sayHello(String name) {
		System.out.println(name);
		return "你好 "+name+" : provider-> wulin:"+port;
	}

	@Override
	public String info(String sfzh, Integer hight) {
		System.out.println(sfzh);
		return "sfzh:"+sfzh+"->hight:"+hight;
	}
	
}
