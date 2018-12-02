package com.xzj.sbtest.mapper;


import com.xzj.sbtest.entity.StudentDO;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

@Component
public interface StudentMapper extends Mapper<StudentDO> {

}
