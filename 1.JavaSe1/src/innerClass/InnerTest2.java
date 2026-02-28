package innerClass;

class Outer {
    private int member;
    static private int staticMember;
    public Outer(){
        System.out.println("Outer");
    }
    private void run(){
        System.out.println("Outer is running");
    }
    private static void staticRun(){
        System.out.println("static Outer is running");
    }
    public class Inner1{
        public Inner1(){
            var tmp=staticMember;
            tmp=member;
            System.out.println("Inner1");
            run();
            staticRun();
        }
    }
    public static class Inner2{
        public Inner2(){
            var tmp=staticMember;
//            tmp=member;
            System.out.println("static Inner2");
//            run();
            staticRun();
        }
    }
}

public class InnerTest2 {
    public static void main(String[] args) {
        System.out.println("=====Outer:");
        new Outer();
        System.out.println("=====static Inner:");
        new Outer().new Inner1();
        System.out.println("=====Inner:");
        new Outer.Inner2();
    }
}
