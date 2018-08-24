
package com.alibaba.dubbo.demo.provider.api;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.demo.DemoService;
import com.alibaba.dubbo.rpc.RpcContext;

@Service
public class DemoApiServiceImpl implements DemoService {

    public String sayHello(String name) {
        System.out.println("9999999999[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "999999999999Hello " + name + ", response form provider: " + RpcContext.getContext().getLocalAddress();
    }
    
    @Override
	public String info(String sfzh, Integer hight) {
		System.out.println(sfzh);
		return "sfzh:"+sfzh+"->hight:"+hight;
	}

}