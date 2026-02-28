package interface1;

class CameraConfig {
    public static boolean isRecordingBanned = false;
}

interface camara {
    void takePicture();//抽象方法

    default void recordVideo() {//默认方法，所有类能直接用，也可以再重写
        if (CameraConfig.isRecordingBanned)
            System.out.println("录制已被禁用");
        else
            System.out.println("虚拟录制");
    }
    static void exist(){
        System.out.println("相机运行中");
    }
}

class MyCamara implements camara {
    public String name;

    public MyCamara(String name) {
        this.name = name;
    }

    @Override
    public void takePicture() {
        if (CameraConfig.isRecordingBanned)
            System.out.println("Recoring is ban");
        else
            System.out.println(name + " take picture.");
    }
}

public class InterfaceTest3 {
    public static void main(String[] args) {
        camara mc = new MyCamara("Sony");
        mc.recordVideo();
        mc.takePicture();
        CameraConfig.isRecordingBanned = true;
        mc.takePicture();
    }
}
