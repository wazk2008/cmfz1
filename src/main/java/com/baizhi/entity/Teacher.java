package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget(value = "Teacher")
public class Teacher {
    @ExcelIgnore
    private String id;
    @Excel(name = "授课老师",needMerge = true)
    private String name;


}
