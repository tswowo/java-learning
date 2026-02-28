package API1;

import java.util.*;

public class listTest1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Integer n= in.nextInt();
//        List<Integer> a=new ArrayList<Integer>(n);
        //ArrayList构造时输入的大小只是预先分配的空间大小
//        List<Integer> a=new LinkedList<>();
//        List<Integer>a=new ArrayList<>();
        List<Integer>b=new LinkedList<>(Arrays.asList(1,2,3,4,5));
        List<Integer>a=new ArrayList<>(b);
        Collections.sort(a);
        for(var x:a)//并不会修改元素，因为这里是创建的副本
            x=x*10;
//        a.removeAll(b);//删除并集
        System.out.println(a);
        ListIterator<Integer>it=a.listIterator();
        while(it.hasNext()){
            it.set(it.next()*10);
        }
        a.sort(Comparator.naturalOrder());
        System.out.println(a);
        var c=a.subList(1,3);//begin end 同地址的子数组
        c.set(1,2);
        System.out.println(c);
        System.out.println(a);
    }
}