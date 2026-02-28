package mybatis.mapper;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {


    /**
     * 查询全部学生信息
     */
    @Select("SELECT * FROM student")
    List<Student> findAllStudent();

    /**
     * 插入一条数据
     */
    @Insert("INSERT INTO student (id,name,no,gender,phone,id_card,degree,graduation_date,create_time,update_time) VALUES (#{id},#{name},#{no},#{gender},#{phone},#{idCard},#{degree},#{graduationDate},#{createTime},#{updateTime})")
    Integer insertStudent(Student student);

    /**
     * 根据ID更新学生信息
     */
    @Update("UPDATE student SET no=#{no},phone=#{phone},id_card=#{idCard} WHERE id=#{id}")
    Integer updateStudent(Student student);

    /**
     * 根据ID查询学生信息
     */
    Student findStudentById(Integer id);

    /**
     * 根据ID删除学生信息
     */
    Integer deleteStudentById(Integer id);
}
