package thread2.threadSoft;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//1.同步代码块

public class test1 {

    public static void main(String[] args) {
        Account1 acc = new Account1("123456", 5000);
        new drawThread1("小明", acc).start();
        new drawThread1("小红", acc).start();
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Account1 {
    private String cardId;
    private int money;

    public void drawMoney(int drawMoney) {
        String name = Thread.currentThread().getName();
        synchronized (this) {
            //"其实这里随便放一个唯一性的对象就可以，比如一个在常量池里的字符串"
            //只是确保两个线程使用的是同一个对象
            //但是要防止其他无关线程的运行
            //对于静态方法就可以用Account1.class了
            //放this的好处是锁对象就是this，那么当两个线程同时访问this对象时，就会锁住this对象
            if (money >= drawMoney) {
                money -= drawMoney;
                System.out.println(name + "取钱成功，余额为：" + money);
            } else {
                System.out.println(name + "取钱失败，余额不足");
            }
        }
    }
}

class drawThread1 extends Thread {
    private Account1 acc;//记住线程对象要处理的账户对象

    public drawThread1(String name, Account1 acc) {
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        acc.drawMoney(5000);
    }
}