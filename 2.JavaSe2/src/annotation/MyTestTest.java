package annotation;

import java.lang.reflect.Method;

public class MyTestTest {
    public static void main(String[] args) {
        //1.获取类
        Class cls = B.class;
        //2.获取方法
        Method[] methods = cls.getDeclaredMethods();
        for (Method m : methods) {
            //3.判断方法上是否有MyTest注解
            if (m.isAnnotationPresent(MyTest.class)) {
                //4.执行方法
                try {
                    int count = m.getAnnotation(MyTest.class).count();
                    for (int i = 0; i < count; i++)
                        m.invoke(new B());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class B {
    @MyTest(count = 3)
    public void method1() {
        System.out.println("执行了方法1");
    }

    public void method2() {
        System.out.println("执行了方法2");
    }

    @MyTest
    public void method3() {
        System.out.println("执行了方法3");
    }
}