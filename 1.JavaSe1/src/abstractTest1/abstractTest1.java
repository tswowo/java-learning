package abstractTest1;

abstract class animal{//抽象类不可实例化
    public void eat(){//默认实现
        System.out.println("吃东西");
    }
    public int age=0;
}

class cat extends animal{
    @Override
    public void eat() {
        System.out.println("猫吃东西");
    }
}

public class abstractTest1 {
    public static void main(String[] args) {
        animal Animal1=new animal(){
        };
        animal Animal2=new animal(){
            @Override
            public void eat() {
                System.out.println("小狗吃东西");
            }
        };
        animal Animal3=new cat();
        Animal1.eat();
        Animal2.eat();
        Animal3.eat();
    }
}
