package collections1;

import java.util.Collection;
import java.util.ArrayList;
import java.util.function.Consumer;

public class collectionsTest1 {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("刘备");
        c.add("关羽");
        c.add("张飞");
        c.add("赵云");
        c.forEach(new Consumer<String>(){
            @Override
            public void accept(String s) {
                s=s+1;
                System.out.println(s);
            }
        });
        System.out.println(c);
    }
}