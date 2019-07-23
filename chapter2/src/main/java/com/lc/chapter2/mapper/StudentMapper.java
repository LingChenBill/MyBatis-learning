package com.lc.chapter2.mapper;

import com.lc.chapter2.pojo.Student;
import org.apache.ibatis.annotations.Param;

/**
 * 学生表映射器mapper。
 *
 * @author zyz.
 */
public interface StudentMapper {

    // 按学生id查询。
    Student getStudent(@Param("id") Integer id);
}