package API1;

public class StringTest1 {
    public static void main(String[] args) {
        StringBuilder strb1=new StringBuilder();
        strb1.append("HELLO");
        strb1.insert(strb1.length(),"qwq");
        strb1.delete(1,2);
        System.out.println(strb1);
        strb1.reverse();
        var str1=strb1.toString();
        System.out.println(str1);

        String s1="123";
        String s2;
//        s2=new String(s1);//这样是不同指向
        s2=s1;//这样是相同指向
        s1+="45";//这样其实是改变了s1
        System.out.println(s1);
        System.out.println(s2);


    }
}
