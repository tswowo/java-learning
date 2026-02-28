package thread1;

public class ThreadTest1 {
    static class MyThread1 extends Thread{
        public MyThread1() { }
        @Override
        public void run() {
            System.out.println("A线程执行中");
        }
    }
    static class MyRunnable1 implements Runnable{
        @Override
        public void run() {
            System.out.println("B线程执行中");
        }
    }
    public static void main(String[] args) {
        //方法1 继承Thread重写run()
        MyThread1 t1 = new MyThread1();
        t1.start();
        //方法2 Thread+MyRunnable
        Runnable r1 = new MyRunnable1();
        Thread t2 = new Thread(r1);
        t2.start();
    }
}
