package com.xzj.sbtest.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Table(name = "xzjtest")
public class StudentDO {
    @Id
    private Integer id;

//    @NotEmpty(message = "名字不能为空", groups = {com.xzj.sbtest.validation.validgroup1.class})
    @NotEmpty(message = "名字不能为空")
    private String name;
//    @Min(value = 18, message = "未成年人", groups = {com.xzj.sbtest.validation.validgroup2.class})
    @Min(value = 18)
    private Integer age;
    @NotEmpty(message = "成绩不能为空")
    private String score;

    @Override
    public String toString() {
        return "StudentDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
