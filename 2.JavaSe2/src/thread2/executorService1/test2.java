package thread2.executorService1;

//2.线程池处理Callable

import java.util.*;
import java.util.concurrent.*;

public class test2 {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(3, 5,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        List<Future<String>> list = new ArrayList<>(5);
        for(int i=0;i<5;i++)
            list.add(es.submit(new MyTask2(i)));
        try {
            for(Future<String> future:list)
                System.out.println(future.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class MyTask2 implements Callable<String> {
    int n;
    MyTask2(int n) {
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res+=i;
        }
        return "子线程"+Thread.currentThread().getName()+"执行结果为："+res;
    }
}