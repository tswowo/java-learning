package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id; // ID, 主键
    private String name; // 姓名
    private String no; // 学号
    private Integer gender; // 性别, 1: 男, 2: 女
    private String phone; // 手机号
    private String idCard; // 身份证号
    private Integer degree; // 最高学历, 1:初中, 2:高中, 3:大专, 4:本科, 5:硕士, 6:博士
    private LocalDate graduationDate; // 毕业时间
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 修改时间
}
