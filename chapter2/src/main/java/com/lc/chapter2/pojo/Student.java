package com.lc.chapter2.pojo;

import com.lc.chapter2.enums.Sex;
import lombok.Data;

import java.util.List;

/**
 * Class: 学生表pojo类。
 *
 * @author zyz.
 */
@Data
public class Student {

    // 编号.
    private Integer id;

    // 姓名.
    private String cnName;

    // 性别.
    private Sex sex;

    // 学生证号.
    private String selfCardNo;

    // 备注.
    private String note;

    // 学生证号(学生与学生证是一对一关系。)
    private StudentSelfCard studentSelfCard;

    // 学生课程(学生与课程是一对多关系)
    private List<StudentLecture> studentLectureList;
}
