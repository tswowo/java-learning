package mybatis;

import mybatis.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pojo.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class SpringBootMybatisApplicationTests {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testFindAll() {
        List<Student> studentList = studentMapper.findAllStudent();
    }

    @Test
    public void testInsertStudent() {
        Student student = new Student();
        student.setName("小王");
        student.setNo("20210002");
        student.setGender(1);
        student.setPhone("12345678902");
        student.setIdCard("123456789012345678");
        student.setDegree(3);
        student.setGraduationDate(LocalDate.of(2023, 5, 1));
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        Integer result = studentMapper.insertStudent(student);
        System.out.println("插入成功:" + result);
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student();
        student.setId(1);
        student.setNo("20210001");
        student.setPhone("12345678901");
        student.setIdCard("123456789012345678");
        Integer result = studentMapper.updateStudent(student);
        System.out.println("更新成功:" + result);
    }

    @Test
    public void testFindStudentById() {
        Integer id = 1;
        Student student = studentMapper.findStudentById(id);
        System.out.println(student);
    }

    @Test
    public void testDeleteStudentById() {
        Integer id = 1;
        Integer result = studentMapper.deleteStudentById(id);
        System.out.println("删除成功:" + result);
    }
}
