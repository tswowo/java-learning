package thread2.createThread;

public class createThread2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("C线程执行中"));
        t1.start();
        for(int i=0;i<5;i++) {
            Thread t2 = new Thread(new myRunnable2());
            t2.start();
            if(i==0) {
                try {
                    t2.join(10,100);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

class myRunnable2 implements Runnable{
    @Override
    public void run() {
        System.out.println("D线程执行中");
    }
}