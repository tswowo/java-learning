package lambda1;

public class LambdaTest1 {
    public static void main(String[] args) {
//        Animal1 dog=new Animal1(){
//            @Override
//            public void eat() {
//                System.out.println("小狗吃东西");
//            }
//        };
        //Lambda也只能简化函数式接口的匿名内部类
        Animal1 dog=()->//函数式接口只有一个方法，这里写的当然会被指定为这个方法的实现
            System.out.println("小狗吃东西");//单行语句，return是隐藏的
        dog.eat();
        Animal1 threeCat=()->{
            System.out.println("三只小猫吃东西");//可以用{}写上代码块，即抽象方法的实现
            return;
        };
    }
}

//函数式接口，是只有一个抽象方法的接口
@FunctionalInterface //函数式接口的注解
interface Animal1 {
    void eat();//函数式接口的核心要求在于：有且只有一个这样的抽象方法
    //可以存在有默认实现的方法(不能没有实现不然这个方法也是抽象方法了)
    default void drink(){
        System.out.println("喝水");
    }
    //可以有变量
    static int id=0;
    int age = 0;
    //可以有静态方法
    static private int getId(){
        return id;
    }
    //其实没什么别的要求了，满足核心要求就可以
}