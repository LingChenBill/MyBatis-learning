package com.lc.chapter2.enums;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 性别枚举class
 *
 * @author zyz.
 */
public enum Sex {

    MALE(3, "男"), FEMALE(4, "女");

    private int id;

    private String name;

    private Sex(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Sex getSex(int id) {
        if (id == 1) {
            return MALE;
        } else if (id == 2) {
            return FEMALE;
        }

        return null;
    }
}
