package cn.wulin.dubbo.rpc.proxy;

import java.lang.reflect.Method;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.utils.UrlUtils;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcInvocation;
import com.alibaba.dubbo.rpc.proxy.javassist.JavassistProxyFactory;

public class TestJavassistProxyFactory {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		JavassistProxyFactory javassistProxyFactory = new JavassistProxyFactory();
		
		TestProxyServiceImpl testProxy = new TestProxyServiceImpl();
		
		URL url = new URL("temp", "localhost", 8080);
//		url = url.addParameter("interfaces", "cn.wulin.dubbo.rpc.proxy.TestProxyService");
		
		Invoker<TestProxyService> invoker = javassistProxyFactory.getInvoker(testProxy, TestProxyService.class, url);
		Result invoke = invokeMethod(invoker);
		
		//得到代理
		TestProxyService proxy = javassistProxyFactory.getProxy(invoker);
//		invoker = javassistProxyFactory.getInvoker(proxy, TestProxyService.class, url);
//	    invoke = invokeMethod(invoker);
		
		
		System.out.println(invoke);
		System.out.println(proxy);
		
	}

	private static Result invokeMethod(Invoker<TestProxyService> invoker) throws NoSuchMethodException {
		Class<?>[] paramsType = new Class<?>[]{String.class,String.class};
		Object[] paramsValue = new Object[]{"wulin","123"};
		Method method = TestProxyService.class.getMethod("hi", paramsType);
		Invocation invocation = new RpcInvocation(method,paramsValue);
		
		Result invoke = invoker.invoke(invocation);
		return invoke;
	}

}
