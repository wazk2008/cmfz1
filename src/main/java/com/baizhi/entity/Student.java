package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget(value = "Student")
public class Student {
    @Excel(name = "编号",width = 20,height = 15)
    private String id;
    @Excel(name = "姓名",width = 20,height = 15)
    private String name;
    @Excel(name = "头像",width = 20,height = 15,imageType = 1,type = 2)
    private String sex;
    @Excel(name = "生日",width = 20,height = 15,format = "yyyy-MM-dd HH:mm:ss")
    private Date bir;



}
