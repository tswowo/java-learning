package org.javaweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClazzQueryParam {
    String name;
    LocalDate begin;
    LocalDate end;
    Integer page = 1;
    Integer pageSize = 10;
}
