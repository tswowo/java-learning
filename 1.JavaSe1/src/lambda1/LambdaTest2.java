package lambda1;

import java.util.Arrays;
import java.util.Scanner;

class Student2 {
    String name;
    int age;

    Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name:" + name + ",age:" + age;
    }
}

@FunctionalInterface
interface Calculate1 {
    int calculate(int a,int b);
}

public class LambdaTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student2[] arr = new Student2[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Student2(sc.next(), sc.nextInt());
        }
        Arrays.sort(arr, (Student2 a, Student2 b) -> {
            if (!a.name.equals(b.name))
                return a.name.compareTo(b.name);
            return a.age - b.age;
        });
        for (var student : arr)
            System.out.println(student);

        Calculate1 myadd=(a, b)-> {
            return a + b;
        };
        Calculate1 mymul=(c, d)->c*d;
        System.out.println("1+2="+myadd.calculate(1,2));
        System.out.println("1*2="+mymul.calculate(1,2));
    }
}
