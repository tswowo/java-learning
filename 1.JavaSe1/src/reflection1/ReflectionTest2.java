package reflection1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class User {
    // 无参构造方法
    public User() {
        System.out.println("无参构造");
    }

    // 一个参数构造方法
    public User(String name) {
        System.out.println("一个参数: " + name);
    }

    // 多个参数构造方法
    public User(String name, Integer age) {
        System.out.println("多个参数: " + name + ", " + age);
    }

    // 受保护的构造方法
    protected User(boolean tmp) {
        System.out.println("受保护构造: " + tmp);
    }

    // 私有的构造方法
    private User(Integer tmp) {
        System.out.println("私有构造: " + tmp);
    }
}

public class ReflectionTest2 {
    public static void main(String[] args) {
        try {
            Class<?> clazz = User.class;

            System.out.println("===== 所有公有构造方法 =====");
            Constructor[] conArray = clazz.getConstructors();
            for (Constructor c : conArray)
                System.out.println(c);

            System.out.println("\n===== 所有构造方法（包括私有、受保护等） =====");
            conArray = clazz.getDeclaredConstructors();
            for (Constructor c : conArray)
                System.out.println(c);

            System.out.println("\n===== 调用公有无参构造 =====");
            Constructor con1 = clazz.getConstructor();
            User u1 = (User) con1.newInstance();

            System.out.println("\n===== 调用公有单参数构造 =====");
            Constructor con2 = clazz.getConstructor(String.class);
            User u2 = (User) con2.newInstance("张三");

            System.out.println("\n===== 调用公有多参数构造 =====");
            Constructor con3 = clazz.getConstructor(String.class, Integer.class);
            User u3 = (User) con3.newInstance("李四", 20);

            System.out.println("\n===== 调用受保护构造 =====");
            Constructor con4 = clazz.getDeclaredConstructor(boolean.class);
            con4.setAccessible(true); // 突破访问限制
            User u4 = (User) con4.newInstance(true);

            System.out.println("\n===== 调用私有构造 =====");
            Constructor con5 = clazz.getDeclaredConstructor(Integer.class);
            con5.setAccessible(true); // 突破访问限制
            User u5 = (User) con5.newInstance(100);

        } catch (NoSuchMethodException e) {
            System.out.println("未找到指定构造方法: " + e.getMessage());
        } catch (InstantiationException e) {
            System.out.println("实例化失败: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("访问权限不足: " + e.getMessage());
        } catch (InvocationTargetException e) {
            System.out.println("构造方法执行出错: " + e.getCause().getMessage());
        }
    }
}
