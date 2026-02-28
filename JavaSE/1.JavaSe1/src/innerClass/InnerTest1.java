package innerClass;

class Test1{
    static private int id;
    static{
        id=0;
        System.out.println(id+"======静态代码块执行======");
    }
    {
        id++;
        System.out.println(id+"======实例代码块执行======");
    }
    public Test1(){
        System.out.println("======构造器执行======");
    }
}

public class InnerTest1 {
    public static void main(String[] args) {
        new Test1();
        new Test1();
        new Test1();
    }
}
