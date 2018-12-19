package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String phone;
    private String password;
    private String salt;
    private String sign;
    private String head_pic;
    private String name;
    private String aharma;
    private String sex;
    private String province;
    private String city;
    private String status;
    private Date reg_date;


}
