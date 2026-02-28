package thread2.createThread;

public class createThread1 {
    public static void main(String[] args) {
        Thread t1 = new MyThread1();
        t1.start();
        Thread t2=new Thread(){
            @Override
            public void run() {
                System.out.println("B线程执行中");
            }
        };
        t2.start();
    }
}

class MyThread1 extends java.lang.Thread{
    @Override
    public void run() {
        System.out.println("A线程执行中");
    }
}
