package innerClass;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;

class student1 {
    private String name;
    private int age;

    public student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public student1() {
        name = "";
        age = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class InnerTest5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        student1[] students = new student1[in.nextInt()];
        for(int i = 0; i < students.length; i++) {
            students[i] = new student1(in.next(), in.nextInt());
        }
        Arrays.sort(students, new Comparator<student1>() {
            @Override
            public int compare(student1 a, student1 b) {
                if (!a.getName().equals(b.getName()))
                    return a.getName().compareTo(b.getName());
                return a.getAge() - b.getAge();
            }
        });
        for(int i = 0; i < students.length; i++) {
            System.out.println(students[i].getName()+" "+students[i].getAge());
        }
    }
}
