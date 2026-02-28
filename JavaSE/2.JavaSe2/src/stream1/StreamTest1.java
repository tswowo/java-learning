package stream1;

import java.util.*;
import java.util.stream.Stream;

public class StreamTest1 {
    public static void main(String[] args) {
        System.out.println("List的流:");
        List<String> list = new ArrayList<>(Arrays.asList("张三", "张小四", "张五", "赵小六", "孙七八"));
        Stream<String> stream =list.stream().filter(name->name.charAt(0)=='张').filter(name->name.length()==2);
        stream.forEach(System.out::println);
        System.out.println("Map的流:");
        Map<String,Integer>mp=new HashMap<>();
        mp.put("张三",18);
        mp.put("张小四",19);
        mp.put("张五",20);
        mp.keySet().stream().filter(name->name.startsWith("张")).filter(name->name.length()==3).forEach(System.out::println);
        System.out.println("arr的流:");
        String[] arr=new String[]{"张三","张小四","张五","赵小六","孙七八"};
        Stream<String> stream1 = Arrays.stream(arr).filter(name->name.charAt(0)=='张').filter(name->name.length()==2);
        stream1.forEach(System.out::println);
    }
}
