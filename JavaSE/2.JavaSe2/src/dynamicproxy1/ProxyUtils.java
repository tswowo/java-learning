package dynamicproxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtils {
    public static StarService createProxy(Star s) {
        StarService proxy = (StarService) Proxy.newProxyInstance(
                ProxyUtils.class.getClassLoader(),
                s.getClass().getInterfaces(),
                new InvocationHandler(){
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        String methodName = method.getName();
                        if(methodName.equals("sing")){
                            System.out.println("开始唱歌代理");
                        }else if(methodName.equals("dance")){
                            System.out.println("开始跳舞代理");
                        }
                        Object result = method.invoke(s, args);
                        System.out.println("结束代理");
                        return result;
                    }
                }
                );
        return proxy;
    }
}
