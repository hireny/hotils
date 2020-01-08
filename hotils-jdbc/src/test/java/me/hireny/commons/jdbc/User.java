package me.hireny.commons.jdbc;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/24 14:49
 */
@Data
@ToString
public class User {

    private Integer id;
    private String username;
    private String password;
    private String gender;
    private String email;
    private String telephone;
    private String introduce;
    private String activeCode;
    private int state;
    private String role;
    private Timestamp registTime;
}
