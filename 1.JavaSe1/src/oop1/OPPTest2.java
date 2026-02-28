package oop1;

class Animal {
    private String name;

    public Animal(String name) {//含参构造器
        this.name = name;
    }

    public Animal() {//无参构造器
        this.name = "未知动物";
    }

    public void eat() {
        System.out.println("动物吃东西");
    }
}

class cat extends Animal {
    private int age;

    public cat(String name, int age) {
        super(name);
        //子类的构造一定会先调用关于父类的super构造器，super构造器使用前不允许添加其余语句
        //如果没有显式调用super，编译器会自动添加super构造语句，并调用该父类的无参构造器（此时要求父类必须有无参构造器）
        this.age = age;
    }
    public cat(){
        //这里什么都没有，但其实已经调用了super()即Animal()
    }

    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }
    @Override
    public void eat(){
        System.out.println("猫吃猫粮");
    }
}

class PersianCat extends cat {
    public PersianCat(String name, int age) {
        super(name, age);
    }

    public void sleep() {
        System.out.println("波斯猫睡觉了");
    }

    @Override
    public void eat(){
        System.out.println("波斯猫吃酱菜罐头");
    }
}

public class OPPTest2 {
    public static void main(String[] args) {
        PersianCat a = new PersianCat("我是波斯猫测试", 100);
        a.eat();
        a.catchMouse();
        a.sleep();
    }
}
