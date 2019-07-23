package com.lc.chapter2.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Class: 学生课程pojo类。
 *
 * @author zyz.
 */
@Data
public class StudentLecture {

    // 编号.
    private Integer id;

    // 学生编号.
    private Integer studentId;

    // 课程.
    private Lecture lecture;

    // 评分.
    private BigDecimal grade;

    // 备注.
    private String note;

}
