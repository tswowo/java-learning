package thread2.executorService1;

import java.util.*;
import java.util.concurrent.*;

public class test4 {
    public static void main(String[] args) {
        int peopleNum = 5;
        List<Integer> redPacket = getRedPacket();
        ThreadFactory threadFactory = new ThreadFactory() {
            private int count = 1;

            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r, "用户" + count);
                count++;
                return thread;
            }
        };
        ExecutorService es = new ThreadPoolExecutor(3, 5,
                10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy()
        );
        for (int i = 1; i <= peopleNum; i++) {
            es.execute(new PeopleGetRedPacket(redPacket));
        }
    }

    static List<Integer> getRedPacket() {
        List<Integer> list = new LinkedList<>();
        Random r = new Random();
        for (int i = 0; i < 160; i++)
            list.add(r.nextInt(30) + 1);
        for (int i = 160; i < 200; i++)
            list.add(r.nextInt(70) + 31);
        Collections.shuffle(list);
        return list;
    }
}

class PeopleGetRedPacket implements Runnable {
    final List<Integer> redPacket;

    public PeopleGetRedPacket(List<Integer> redPacket) {
        this.redPacket = redPacket;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName(); // 此时能拿到线程工厂定义的“用户X”
        while (true) {
            synchronized (redPacket) {
                if (redPacket.isEmpty())
                    break;
                int packet = redPacket.remove(0);
                System.out.println(name + "抢到：" + packet + "元，剩余：" + redPacket.size());
                if (redPacket.isEmpty())
                    System.out.println("========= 活动结束 =========");
            }
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}