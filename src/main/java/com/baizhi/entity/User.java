package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String username;
//    private String password;
    private String mobile;
//    private String salt;
//    private String dharma;
//    private String province;
//    private String city;
    private String sex;
//    private String photo;
//    private String sign;
//    private String status;
    private Date registDate;



}
