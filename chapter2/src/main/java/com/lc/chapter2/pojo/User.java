package com.lc.chapter2.pojo;

import com.lc.chapter2.enums.Sex;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class User {
    private Long id;
    private String userName;
    private String cnname;
//    private String birthday;
    private Sex sex;
    private String email;
    private String mobile;
    private String note;

}