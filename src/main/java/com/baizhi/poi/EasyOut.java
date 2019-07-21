package com.baizhi.poi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Student;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EasyOut {

    public static void main(String[] args) throws Exception {

        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setId(i+"");
            student.setName("张三"+i);
            student.setSex("d:/timg.jpg");
            student.setBir(new Date());

            list.add(student);
        }

//        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("计算机一班学生","学生信息表"),
//                Student.class, list);

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), Student.class, list);
        FileOutputStream fos = new FileOutputStream("D:/学生信息.xls");
        workbook.write(fos);
        fos.close();


//        workbook.write(new FileOutputStream(new File("d:/学生信息.xls")));
    }

}
