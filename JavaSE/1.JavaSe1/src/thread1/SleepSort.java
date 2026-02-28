package thread1;

import java.util.*;

class SleepSortThread extends Thread{
    private int id;
    public SleepSortThread(int id) {
        this.id = id;
    }
    @Override
    public void run(){
        try {
            Thread.sleep(this.id * 100);
            System.out.print(this.id + " ");
        } catch (InterruptedException e) {
            System.out.println("线程" + this.id + "被中断");
        }
    }
}

public class SleepSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<SleepSortThread> threads = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            int num = sc.nextInt();
            threads.add(new SleepSortThread(num));
        }
        for(SleepSortThread thread : threads)
            thread.start();
        for(SleepSortThread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sc.close();
    }
}
