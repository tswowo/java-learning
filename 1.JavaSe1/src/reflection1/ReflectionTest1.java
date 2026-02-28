package reflection1;

import java.util.*;
import java.lang.*;

public class ReflectionTest1 {
    public static void main(String[] args) {
        //原理是获取类的Class类元信息
        //一 获取Class对象
        String str= "Hello world";
        Class<?> cls;
        //1 需要先有对象
        cls=str.getClass();
        //2 需在编译器确定类型
        cls=String.class;
        //3 通过Class.forName 运行时动态加载 需要异常处理才能通过编译
        try{
            cls = Class.forName("java.lang.String");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(cls);
        String name=cls.getName();
        String simpleName=cls.getSimpleName();
        Class<?>theSuper=cls.getSuperclass();
        Class<?>[] interfaces=cls.getInterfaces();
        for(var i:interfaces)
            System.out.println(i);
    }
}
