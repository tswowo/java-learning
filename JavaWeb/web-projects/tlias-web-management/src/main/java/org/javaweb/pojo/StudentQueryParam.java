package org.javaweb.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQueryParam {
    String name;
    Integer degree;
    Integer clazzId;
    Integer page = 1;
    Integer pageSize = 10;
}
