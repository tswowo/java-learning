package thread2.threadSoft;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//1.同步方法

public class test2 {

    public static void main(String[] args) {
        Account2 acc = new Account2("123456", 5000);
        new drawThread2("小明", acc).start();
        new drawThread2("小红", acc).start();
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Account2 {
    private String cardId;
    private int money;

    public synchronized void drawMoney(int drawMoney) {
        //这里实例方法里的的锁对象实际上默认是用this作为锁
        //静态static方法就默认用类名.class作为锁
        String name = Thread.currentThread().getName();
        if (money >= drawMoney) {
            money -= drawMoney;
            System.out.println(name + "取钱成功，余额为：" + money);
        } else {
            System.out.println(name + "取钱失败，余额不足");
        }
    }
}

class drawThread2 extends Thread {
    private Account2 acc;//记住线程对象要处理的账户对象

    public drawThread2(String name, Account2 acc) {
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        acc.drawMoney(5000);
    }
}