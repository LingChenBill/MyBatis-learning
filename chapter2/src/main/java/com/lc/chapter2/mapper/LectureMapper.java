package com.lc.chapter2.mapper;

import com.lc.chapter2.pojo.Lecture;
import com.lc.chapter2.pojo.StudentSelfCard;
import org.apache.ibatis.annotations.Param;

/**
 * 课程表映射器mapper。
 *
 * @author zyz.
 */
public interface LectureMapper {

    // 按课程编号查询。
    Lecture getLecture(@Param("id") Integer id);
}