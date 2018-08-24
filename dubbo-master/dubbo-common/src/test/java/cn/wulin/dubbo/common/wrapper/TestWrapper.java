package cn.wulin.dubbo.common.wrapper;

import java.lang.reflect.InvocationTargetException;

import com.alibaba.dubbo.common.bytecode.NoSuchMethodException;
import com.alibaba.dubbo.common.bytecode.Wrapper;

public class TestWrapper {
	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		TestWrapper testWrapper = new TestWrapper();
		testWrapper.entry();
	}
	
	public void entry() throws InvocationTargetException, InstantiationException, IllegalAccessException{
		TestWrapperService instance = new TestWrapperServiceImpl();
		Wrapper wrapper = Wrapper.getWrapper(TestWrapperServiceImpl.class);
//		Wrapper0 wrapper = Wrapper0.class.newInstance();
		
		Class<?>[] paramsType = new Class<?>[]{String.class,String.class};
		Object[] paramsValue = new Object[]{"wulin","123"};
		
		
		testInvokeMethod(instance, wrapper, paramsType, paramsValue);
	}
	
	public void testInvokeMethod(TestWrapperService instance,Wrapper wrapper,Class<?>[] paramsType,Object[] paramsValue) throws InvocationTargetException{
		//调用方法
		Object invokeMethod = wrapper.invokeMethod(instance, "hi", paramsType, paramsValue);
		System.out.println(invokeMethod);
		
		String[] propertyNames = wrapper.getPropertyNames();
		String[] methodNames = wrapper.getMethodNames();
		wrapper.setPropertyValue(instance, "age", 11);
		
		invokeMethod = wrapper.invokeMethod(instance, "hi", paramsType, paramsValue);
		System.out.println(invokeMethod);
		
		System.out.println();
		
		
		
	}

}
