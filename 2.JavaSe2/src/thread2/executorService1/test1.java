package thread2.executorService1;

//1.线程池处理Runnable

import java.util.concurrent.*;

public class test1 {
    public static void main(String[] args) {
        ExecutorService es=new ThreadPoolExecutor(3,5,
        10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        Runnable task=new MyTask1();
        es.execute(task);//核心线程
        es.execute(task);//核心线程
        es.execute(task);//核心线程
        es.execute(task);//核心线程满，放入任务队列中
        es.execute(task);//放入任务队列中
        es.execute(task);//放入任务队列中
        es.execute(task);//放入任务队列中
        es.execute(task);//放入任务队列中
        es.execute(task);//队列满，创建一个非核心线程
        es.execute(task);//创建一个非核心线程

        try {
            es.execute(task);//拒绝策略
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class MyTask1 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<5;i++) {
            System.out.println(Thread.currentThread().getName() + "正在执行执行任务(" + (i + 1) + ")...");
            try {
                Thread.sleep(100000000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}