package API1;

import java.util.*;

public class MapTest1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, String> a;
        a = new HashMap<>();
//        a=new TreeMap<>();
        Integer n = in.nextInt();
        for (int i = 0; i < n; i++) {
            var key = in.nextInt();
            var val = in.next();
            a.put(key, val);
        }
        System.out.println(a);
        a.remove(1, "one");//键值对完全对应才会删除
        a.remove(2);
        for (Integer key : a.keySet())
            System.out.println("Key:" + key + " Value:" + a.get(key));

        for (String val : a.values())
            System.out.println("Value:" + val);

        for (Map.Entry<Integer, String> entry : a.entrySet())
            System.out.println("Key:" + entry.getKey() + " Value:" + entry.getValue());

        Iterator<Map.Entry<Integer, String>> it = a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            if (entry.getKey() == 1)
                it.remove();
            else
                System.out.println("Key:" + entry.getKey() + " Value:" + entry.getValue());
        }


    }
}
