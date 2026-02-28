package thread1;

public class ThreadTest2 {
    static class MyThread1 extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(this.getName());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            printOut(this);
            System.out.println(this.getName() + ": 我即将死去");
        }
    }

    private static void printOut(Thread t) {
        System.out.println(t.getName() + ": 线程状态:");
        System.out.println(t.getName() + ": ID: " + t.threadId());
        System.out.println(t.getName() + ": 名称: " + t.getName());
        System.out.println(t.getName() + ": 状态: " + t.getState());
        System.out.println(t.getName() + ": 优先级: " + t.getPriority());
        System.out.println(t.getName() + ": 后台线程: " + t.isDaemon());
        System.out.println(t.getName() + ": 活着: " + t.isAlive());
        System.out.println(t.getName() + ": 被中断: " + t.isInterrupted());
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread1();
        printOut(t1);
        t1.setPriority(10);
        t1.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        printOut(t1);
    }
}