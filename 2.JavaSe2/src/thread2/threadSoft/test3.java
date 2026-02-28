package thread2.threadSoft;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.concurrent.locks.*;

//3.lock锁
//lock锁是一个接口，有一个实现类ReentrantLock
//lock()获得锁 unlock()释放锁

public class test3 {

    public static void main(String[] args) {
        Account3 acc = new Account3("123456", 5000);
        new drawThread3("小明", acc).start();
        new drawThread3("小红", acc).start();
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Account3 {
    private String cardId;
    private int money;
    private final Lock lk=new ReentrantLock();//加final保护锁

    public synchronized void drawMoney(int drawMoney) {
        //这里实例方法里的的锁对象实际上默认是用this作为锁
        //静态static方法就默认用类名.class作为锁
        String name = Thread.currentThread().getName();
        lk.lock();
        try {
            if (money >= drawMoney) {
                money -= drawMoney;
                System.out.println(name + "取钱成功，余额为：" + money);
            } else {
                System.out.println(name + "取钱失败，余额不足");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            lk.unlock();
        }
    }
}

class drawThread3 extends Thread {
    private Account3 acc;//记住线程对象要处理的账户对象

    public drawThread3(String name, Account3 acc) {
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        acc.drawMoney(5000);
    }
}