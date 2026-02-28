package dynamicproxy1;

public class Test {
    @org.junit.Test
    public void test() {
        Star star = new Star("伟大曼波");
        StarService starService = ProxyUtils.createProxy(star);
        starService.sing("哈基米南北绿豆");
        starService.dance("蓝莲哈");
    }
}