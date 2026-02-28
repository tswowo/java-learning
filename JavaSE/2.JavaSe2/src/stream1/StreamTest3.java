package stream1;

import java.util.*;
import java.util.stream.*;

public class StreamTest3 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("张三", "张小四", "张五", "赵小六", "abc", "abc", "1"));

        List list = names.stream().filter(str -> str.startsWith("张")).collect(Collectors.toList());
        System.out.println(list);

        Set set = names.stream().filter(str -> str.length() == 3).collect(Collectors.toSet());
        System.out.println(set);

        //键是String 值是length
        Map<String, Integer> map = names.stream().collect(Collectors.toMap(
                str -> str,//键
                str -> str.length(),//值
                (oldValue, newValue) -> newValue));//处理重复值
        System.out.println(map);
    }
}
