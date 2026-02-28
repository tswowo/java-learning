package AAAtemp;

abstract class animal{
    public void eat(){
        System.out.println("吃东西");
    }
}

public class tempFile {
    public static void main(String[] args) {
        animal ani=new animal(){
        };
        animal dog=new animal(){
            @Override
            public void eat() {
                System.out.println("小狗吃东西");
            }
        };
        ani.eat();
        dog.eat();
    }
}