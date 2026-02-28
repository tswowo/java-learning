import Emp.EmpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserService3Test {

    @DisplayName("北京验证断言测试")
    @Test
    public void isBeiJingAssertionTest() throws Exception {
        EmpService empService = new EmpService();
        String beijingId = "110101199001011234";
        String nonBeijingId = "440101199001011234";

        Assertions.assertTrue(empService.isBeijing(beijingId), "北京身份证号应返回true");
        Assertions.assertFalse(empService.isBeijing(nonBeijingId), "非北京身份证号应返回false");
    }

    @DisplayName("年龄计算断言测试")
    @Test
    public void ageCalculationAssertionTest() {
        EmpService empService = new EmpService();
        String idCard = "110101199001011234";
        Integer age = empService.getAge(idCard);

        Assertions.assertNotNull(age, "年龄不应为null");
        Assertions.assertTrue(age > 0, "年龄应大于0");
        Assertions.assertTrue(age < 150, "年龄应在合理范围内");
    }

    @DisplayName("性别判断断言测试")
    @Test
    public void genderAssertionTest() {
        EmpService empService = new EmpService();

        String maleId = "110101199001011237"; // 第17位为7(奇数)，应为男性
        String femaleId = "110101199001011247"; // 第17位为8(偶数)，应为女性

        Assertions.assertEquals("男", empService.getGender(maleId), "男性身份证应返回'男'");
        Assertions.assertEquals("女", empService.getGender(femaleId), "女性身份证应返回'女'");
    }

    @DisplayName("出生年份断言测试")
    @Test
    public void birthYearAssertionTest() {
        EmpService empService = new EmpService();
        String idCard = "110101199001011234";
        String year = empService.getYear(idCard);

        Assertions.assertEquals("1990", year, "出生年份应为1990");
        Assertions.assertNotNull(year, "出生年份不应为null");
        Assertions.assertEquals(4, year.length(), "年份应为4位数字");
    }

    @DisplayName("出生月份断言测试")
    @Test
    public void birthMonthAssertionTest() {
        EmpService empService = new EmpService();
        String idCard = "110101199001011234";
        String month = empService.getMonth(idCard);

        Assertions.assertEquals("01", month, "出生月份应为01");
        Assertions.assertNotNull(month, "出生月份不应为null");
        Assertions.assertEquals(2, month.length(), "月份应为2位数字");
    }
}
