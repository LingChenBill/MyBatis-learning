package com.lc.chapter2.mapper;

import com.lc.chapter2.pojo.StudentLecture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生课程表映射器mapper。
 *
 * @author zyz.
 */
public interface StudentLectureMapper {

    // 按学生编号查询。
    List<StudentLecture> findStudentLectureByStuId(@Param("id") Integer id);
}