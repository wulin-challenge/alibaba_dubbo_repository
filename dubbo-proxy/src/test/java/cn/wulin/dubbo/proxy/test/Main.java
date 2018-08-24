package cn.wulin.dubbo.proxy.test;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.rpc.proxy.javassist.JavassistProxyFactory;
import com.alibaba.dubbo.rpc.support.MockInvoker;
/**
 * Created by tangwei on 2016/11/22.
 */
public class Main {
    public static void main(String[] args) {
        DemoService proxy = new JavassistProxyFactory().getProxy(new MockInvoker<DemoService>(new URL("", "", 8888)), new Class[]{DemoService.class});
        proxy.sayHi("wulin");
        System.out.println(proxy);
    }
}