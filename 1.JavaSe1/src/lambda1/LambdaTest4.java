package lambda1;

import java.util.Arrays;
import java.util.Scanner;

class People4 implements Comparable<People4>{
    private String name;
    public int compareTo(People4 o) {
        return this.name.compareTo(o.name);
    }
    static public int staticCompare1(People4 o1, People4 o2) {
        return o1.compareTo(o2);
    }
    public int compare1(People4 o1, People4 o2) {
        return o1.compareTo(o2);
    }
    public People4(String name){
        this.name=name;
    }
}

public class LambdaTest4 {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        Integer n=sc.nextInt();
        People4[] arr=new People4[n];
        for(int i=0;i<n;i++){
            arr[i]=new People4(sc.next());
        }
        Arrays.sort(arr,People4::staticCompare1);//使用类的方法引用
        Arrays.sort(arr,arr[0]::compare1);//在特殊情况下使用实例的方法引用
    }
}
