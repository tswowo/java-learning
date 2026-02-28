package innerClass;

class People1{
    private int heartBeat=100;
    class heart{
        private int heartBeat=80;
        void show(){
            int heartBeat=60;
            System.out.println(heartBeat);
            System.out.println(this.heartBeat);
            System.out.println(People1.this.heartBeat);
        }
    }
}

public class InnerTest3 {
    public static void main(String[] args) {
        People1.heart a=new People1().new heart();
        a.show();
    }
}
