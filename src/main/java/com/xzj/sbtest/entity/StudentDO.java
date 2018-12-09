package com.xzj.sbtest.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * StudentDO class
 *
 * @author ppx
 * @date 2018/12/09
 */
@Data
@Table(name = "xzjtest")
public class StudentDO {
    @Id
    private Integer id;

    @NotEmpty(message = "名字不能为空")
    private String name;

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
