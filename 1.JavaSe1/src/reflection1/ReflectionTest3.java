package reflection1;

import java.lang.reflect.Field;

class user2 {
    public String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    user2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    user2() {
        this.name = "NONE";
        this.age = -1;
    }
}

public class ReflectionTest3 {
    public static void main(String[] args) {
        try {
            user2 u1 = new user2();
            System.out.println("修改前：name=" + u1.getName() + ", age=" + u1.getAge());
            Class<user2> clazz = user2.class;

            Field nameField = clazz.getField("name");
            nameField.set(u1, "反射");

            Field ageField = clazz.getDeclaredField("age");
            ageField.setAccessible(true);
            ageField.set(u1, 18);
            System.out.println("修改后：name=" + u1.getName() + ", age=" + u1.getAge());
        } catch (NoSuchFieldException e) {
            System.out.println("未找到指定字段：" + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("访问权限不足：" + e.getMessage());
        }
    }
}
