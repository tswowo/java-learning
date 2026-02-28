package interface1;
import java.lang.*;

interface camera{
    void takePicture();
}

interface payTool {
    void pay();
}

class MyPhone implements camera,payTool{
    private String name;
    public MyPhone(String name){
        this.name=name;
    }
    @Override
    public void takePicture() {
        System.out.println(name+"拍了照片");
    }
    @Override
    public void pay() {
        System.out.println(name+"支付");
    }
}

public class InterfaceTest2 {
    public static void main(String[] args) {
        MyPhone mp=new MyPhone("安卓手机");
        mp.takePicture();
        mp.pay();

        camera mc=new MyPhone("苹果手机");
        mc.takePicture();

        payTool mt=new MyPhone("鸿蒙手机");
        mt.pay();
    }
}
