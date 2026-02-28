package API1;

import java.util.*;

public class SetTest1 {
    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
//        Set<Integer> a=new HashSet<>();
        var a = new TreeSet<Integer>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            var tmp = in.nextInt();
            a.add(tmp);
        }
//        for (Integer x : a) {
//            System.out.println(x);
//        }
//        Iterator<Integer> it = a.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
        a.stream().forEach(System.out::println);
        Set<Integer>b=new HashSet<>(Arrays.asList(1,2,3,4));
        System.out.println(a);
        System.out.println(b);
        b.addAll(a);
        System.out.println(b);
        b.removeAll(a);
        System.out.println(b);
        a.clear();
        System.out.println(a);
    }
}