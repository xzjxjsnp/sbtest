package com.xzj.sbtest.mapper;


import com.xzj.sbtest.entity.StudentDO;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * StudentMapper interface
 *
 * @author ppx
 * @date 2018/12/09
 */
@Component
public interface StudentMapper extends Mapper<StudentDO> {

}
