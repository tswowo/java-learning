import Emp.EmpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserService1Test {

    @DisplayName("在北京逻辑测试")
    @Test
    public void isBeiJingTest1() throws Exception {
        EmpService empService = new EmpService();
        Assertions.assertTrue(empService.isBeijing("110101199001011234"), "应当为在北京");
        Assertions.assertFalse(empService.isBeijing("440101199001011234"), "应当为不在北京");
    }

    @DisplayName("在北京边界条件测试")
    @Test
    public void isBeiJingTest2() {
        EmpService empService = new EmpService();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            empService.isBeijing("11010119900101123");
        }, "应当抛出IllegalArgumentException");
        Assertions.assertThrows(NullPointerException.class, () -> {
            empService.isBeijing(null);
        }, "应当抛出NullPointerException");
    }

    @DisplayName("年龄计算测试")
    @Test
    public void calculateAgeTest() {
        EmpService empService = new EmpService();
        Integer age = empService.getAge("110101199001011234");
        Assertions.assertNotNull(age, "年龄不应为空");
        Assertions.assertTrue(age > 0 && age < 150, "年龄应在合理范围内");

        // 测试不同出生日期
        Integer age2 = empService.getAge("110101198505151234");
        Assertions.assertNotNull(age2, "年龄不应为空");
    }

    @DisplayName("性别判断测试")
    @Test
    public void getGenderTest() {
        EmpService empService = new EmpService();

        // 测试男性（身份证号第17位为奇数）
        String maleGender = empService.getGender("110101199001011237");
        Assertions.assertEquals("男", maleGender, "性别应为男性");

        // 测试女性（身份证号第17位为偶数）
        String femaleGender = empService.getGender("110101199001011247");
        Assertions.assertEquals("女", femaleGender, "性别应为女性");
    }

    @DisplayName("出生年月获取测试")
    @Test
    public void getBirthInfoTest() {
        EmpService empService = new EmpService();

        // 测试出生年份
        String year = empService.getYear("110101199001011234");
        Assertions.assertEquals("1990", year, "出生年份应为1990");

        // 测试出生月份
        String month = empService.getMonth("110101199001011234");
        Assertions.assertEquals("01", month, "出生月份应为01");
    }
}

