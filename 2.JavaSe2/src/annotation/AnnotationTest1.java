package annotation;

import org.junit.Test;

public class AnnotationTest1 {
    @Test
    public void test1() {
        Class cls = A.class;
        if(cls.isAnnotationPresent(MyAnnotation1.class)){
            MyAnnotation1 annotation = (MyAnnotation1) cls.getDeclaredAnnotation(MyAnnotation1.class);
            String value = annotation.value();
            String name = annotation.name();
            int age = annotation.age();
            double score = annotation.score();
            System.out.println(value + " " + name + " " + age + " " + score);
            System.out.println(annotation);
        }
    }
}

@MyAnnotation1(value = "张三", name = "张三", age = 18, score = 80.0)
class A {
    @MyAnnotation1(value = "李四", name = "李四", age = 24, score = 100.0)
    public void go() {

    }
}
