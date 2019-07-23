package com.lc.chapter2.pojo;

import lombok.Data;

/**
 * Class: 课程表pojo类。
 *
 * @author zyz.
 */
@Data
public class Lecture {

    // 编号.
    private Integer id;

    // 课程名称.
    private String lectureName;

    // 备注.
    private String note;

}
