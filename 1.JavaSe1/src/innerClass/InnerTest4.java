package innerClass;

class People2 {
    void swim() {
        System.out.println("swim");
    }
}

interface People3 {
    void eat();
}

public class InnerTest4 {
    public static void main(String[] args) {
        People2 p1 = new People2();
        People2 p2 = new People2() {
            @Override
            public void swim() {
                System.out.println("乙在游泳");
            }
        };

        People3 p3 = new People3() {
            @Override
            public void eat() {
                System.out.println("丙吃东西");
            }
        };
        p1.swim();
        p2.swim();
        p3.eat();
    }
}
