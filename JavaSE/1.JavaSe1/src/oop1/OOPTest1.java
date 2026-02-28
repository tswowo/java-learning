package oop1;

public class OOPTest1 {
    private String name;
    private int age;

    public OOPTest1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public OOPTest1() {
        this.name = "未知用户";
        this.age = -1;
    }

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

    @Override
    public String toString() {
        return "name:" + name + " age:" + age;
    }

    public static void main(String[] args) {
        var a = new OOPTest1();
        System.out.println(a.getName());
        a.setName("123");
        System.out.println(a.getName());
        System.out.println(a);
        if(args.length!=0)
            OOPTest1.main(new String[0]);//静态方法属于类
    }
}