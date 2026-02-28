import Emp.EmpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserService2Test {
    @DisplayName("测试用户服务")
    @ParameterizedTest
    @ValueSource(strings = {"610110201909091231", "110110201509091109", "510310198812120931"})
    public void testUserService(String idCard) throws Exception {
        EmpService empService = new EmpService();
        System.out.println("测试用户：" + idCard);
        System.out.println("是否是北京：" + empService.isBeijing(idCard));
        System.out.println("年龄：" + empService.getAge(idCard));
        System.out.println("性别：" + empService.getGender(idCard));
        System.out.println("出生年份：" + empService.getYear(idCard));
        System.out.println("出生月份：" + empService.getMonth(idCard));
        System.out.println("---");
    }
}