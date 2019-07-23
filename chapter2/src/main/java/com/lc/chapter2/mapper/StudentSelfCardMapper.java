package com.lc.chapter2.mapper;

import com.lc.chapter2.pojo.StudentSelfCard;
import org.apache.ibatis.annotations.Param;

/**
 * 学生证表映射器mapper。
 *
 * @author zyz.
 */
public interface StudentSelfCardMapper {

    // 按学生编号查询。
    StudentSelfCard findStuentSelfCardByStudentId(@Param("studentId") Integer studentId);

}