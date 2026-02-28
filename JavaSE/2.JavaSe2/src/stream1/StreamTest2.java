package stream1;

import java.util.*;

public class StreamTest2 {
    public static void main(String[] args) {
        //支持链式编程，返回新的stream
        List<String> names = new ArrayList<>(Arrays.asList("张三", "张小四", "张五", "赵小六", "abc", "abc"));
        System.out.println("过滤:");
        names.stream().filter(name -> name.startsWith("张") && name.length() == 2).forEach(str -> System.out.print(str + " "));
        System.out.println("\n映射:");
        names.stream().map(String::toUpperCase).forEach(str -> System.out.print(str + " "));
        System.out.println("\n去重:");
        names.stream().distinct().forEach(str -> System.out.print(str + " "));
        System.out.println("\n排序:");
        names.stream().sorted().forEach(str -> System.out.print(str + " "));
        System.out.println();
        names.stream().sorted(Comparator.reverseOrder()).forEach(str -> System.out.print(str + " "));
        Optional<String> max = names.stream().max(Comparator.comparingInt(String::length));
        System.out.println("\n最大值:" + max.get());
        Optional<String> min = names.stream().min(Comparator.comparingInt(String::length));
        System.out.println("最小值:" + min.get());
        System.out.println("计数:" + names.stream().count());
        String result = names.stream().findAny().orElse("未找到");
        System.out.println("查找结果: " + result);

    }
}
