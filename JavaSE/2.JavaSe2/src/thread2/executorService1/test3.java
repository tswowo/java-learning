package thread2.executorService1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class test3 {
    public static void main(String[] args) {
        ExecutorService es=Executors.newFixedThreadPool(3);
        List<Future<String>> list = new ArrayList<>(5);
        for(int i=0;i<5;i++)
            list.add(es.submit(new MyTask2(i*1000)));
        try {
            for(Future<String> future:list)
                System.out.println(future.get());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
