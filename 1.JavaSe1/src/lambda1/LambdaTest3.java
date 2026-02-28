package lambda1;

import java.util.Arrays;

class Calculate2 {
    static int add(int a, int b) {
        return a + b;
    }
    int mul(int a, int b) {
        return a * b;
    }
}

@FunctionalInterface
interface Calculate3 {
    int calculate(int a, int b);
}

public class LambdaTest3 {
    public static void main(String[] args) {
        //引用静态方法
        Calculate3 myadd = Calculate2::add;
        //引用对象的实例方法
        Calculate2 cal=new Calculate2();
        Calculate3 mymul=cal::mul;
        //引用类的实例方法
        String[] strs={"apple","banana","pear"};//只有obj1.Object::method(obj2)这种A调用B的特殊形式才可以使用
        Arrays.sort(strs,String::compareTo);//实际上是使用了str1.compareTo(str2)
    }
}
