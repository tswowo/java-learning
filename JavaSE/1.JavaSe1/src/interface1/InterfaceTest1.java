package interface1;

interface MyComparator<T>{
    int compareTo(T a,T b);
}

class IntegerComparator implements MyComparator<Integer>{
    @Override
    public int compareTo(Integer a, Integer b){
        return a.compareTo(b);
    }
}

class StringComparator implements MyComparator<String>{
    @Override
    public int compareTo(String a, String b){
        return a.compareTo(b);
    }
}

public class InterfaceTest1 {
    public static void main(String[] args) {
        MyComparator<Integer>intComp=new IntegerComparator();
        System.out.println("整数比较 3 vs 5: " + intComp.compareTo(3, 5));
        System.out.println("整数比较 10 vs 7: " + intComp.compareTo(10, 7));
        MyComparator<String>strComp=new StringComparator();
        System.out.println("字符串比较 'apple' vs 'banana': " + strComp.compareTo("apple", "banana"));
        System.out.println("字符串比较 'cat' vs 'ant': " + strComp.compareTo("cat", "ant"));
    }
}
