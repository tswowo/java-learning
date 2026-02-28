package dynamicproxy1;

public class Star implements StarService {
    public Star(String name) {
        this.name = name;
    }

    String name;

    @Override
    public void sing(String song) {
        System.out.println(name + "开始唱歌" + song);
    }

    @Override
    public void dance(String song) {
        System.out.println(name + "开始跳舞" + song);
    }
}