package com.lc.chapter2.pojo;

import com.lc.chapter2.enums.Sex;
import lombok.Data;

import java.util.Date;

/**
 * Class: 学生证表pojo类。
 *
 * @author zyz.
 */
@Data
public class StudentSelfCard {

    // 编号.
    private Integer id;

    // 学生编号。
    private Integer studentId;

    // 籍贯.
    private String nativeStr;

    // 发证日期.
    private Date issueDate;

    // 结束日期.
    private Date endDate;

    // 备注.
    private String note;

}
