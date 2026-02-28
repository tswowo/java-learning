package thread2.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class createThread3 {
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(new MyCallable());
        new Thread(task,"线程1号").start();
        try {
            System.out.println(task.get());
        } catch (Exception e) {
            e.getMessage();
        }
        FutureTask<Integer> task2 = new FutureTask<>(() -> 100);
        new Thread(task2,"线程2号").start();
        try {
            System.out.println(task2.get());
        } catch (Exception e) {
            e.getMessage();
        }
        Thread t=Thread.currentThread();
        t.setName("主线程");
        System.out.println(t.getName());
    }
}

class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}