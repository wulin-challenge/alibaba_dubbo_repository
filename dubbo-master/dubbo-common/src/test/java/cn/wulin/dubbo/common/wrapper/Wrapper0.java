package cn.wulin.dubbo.common.wrapper;

import java.util.*;
import com.alibaba.dubbo.common.bytecode.ClassGenerator;
import com.alibaba.dubbo.common.bytecode.NoSuchPropertyException;
import com.alibaba.dubbo.common.bytecode.Wrapper;

import cn.wulin.dubbo.common.wrapper.*;
import java.lang.reflect.*;

public class Wrapper0 extends Wrapper implements ClassGenerator.DC
{
    public static String[] pns;
    public static Map pts;
    public static String[] mns;
    public static String[] dmns;
    public static Class[] mts0;
    public static Class[] mts1;
    
    public String[] getPropertyNames() {
        return Wrapper0.pns;
    }
    
    public boolean hasProperty(final String s) {
        return Wrapper0.pts.containsKey(s);
    }
    
    public Class getPropertyType(final String s) {
        return (Class) Wrapper0.pts.get(s);
    }
    
    public String[] getMethodNames() {
        return Wrapper0.mns;
    }
    
    public String[] getDeclaredMethodNames() {
        return Wrapper0.dmns;
    }
    
    public void setPropertyValue(final Object o, final String s, final Object o2) {
        try {
            final TestWrapperServiceImpl testWrapperServiceImpl = (TestWrapperServiceImpl)o;
        }
        catch (Throwable t) {
            throw new IllegalArgumentException(t);
        }
        throw new NoSuchPropertyException(new StringBuffer().append("Not found property \"").append(s).append("\" filed or setter method in class cn.wulin.dubbo.common.wrapper.TestWrapperServiceImpl.").toString());
    }
    
    public Object getPropertyValue(final Object o, final String s) {
        try {
            final TestWrapperServiceImpl testWrapperServiceImpl = (TestWrapperServiceImpl)o;
        }
        catch (Throwable t) {
            throw new IllegalArgumentException(t);
        }
        throw new NoSuchPropertyException(new StringBuffer().append("Not found property \"").append(s).append("\" filed or setter method in class cn.wulin.dubbo.common.wrapper.TestWrapperServiceImpl.").toString());
    }
    
    public Object invokeMethod(final Object o, final String s, final Class[] array, final Object[] array2) throws InvocationTargetException {
        TestWrapperServiceImpl testWrapperServiceImpl;
        try {
            testWrapperServiceImpl = (TestWrapperServiceImpl)o;
        }
        catch (Throwable t) {
            throw new IllegalArgumentException(t);
        }
        try {
            if ("hi".equals(s) && array.length == 1) {
                if (array[0].getName().equals("java.lang.String")) {
                    testWrapperServiceImpl.hi((String)array2[0]);
                    return null;
                }
            }
            if ("hi".equals(s) && array.length == 2) {
                if (array[0].getName().equals("java.lang.String")) {
                    if (array[1].getName().equals("java.lang.String")) {
                        return testWrapperServiceImpl.hi((String)array2[0], (String)array2[1]);
                    }
                }
            }
        }
        catch (Throwable t2) {
            throw new InvocationTargetException(t2);
        }
        try {
			throw new NoSuchMethodException(new StringBuffer().append("Not found method \"").append(s).append("\" in class cn.wulin.dubbo.common.wrapper.TestWrapperServiceImpl.").toString());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
        return null;
    }
}
