package com.baizhi.poi;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.Course;
import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EasyOut1 {

    public static void main(String[] args) throws Exception {

        List<Course> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Course course = new Course();
            course.setId("c"+i);
            course.setName("java"+i+"班");
            course.setTeacher(new Teacher("t"+i,"李老师"+i));
            List<Student> students = new ArrayList<>();
            for (int j = 0; j < 5 ; j++) {
                Student student = new Student();
                student.setId("s"+j);
                student.setName("张三"+j);
                student.setSex("d:/timg.jpg");
                student.setBir(new Date());
                students.add(student);
            }
            course.setStudents(students);
            list.add(course);
        }

        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), Course.class, list);
        FileOutputStream fos = new FileOutputStream("D:/学生上课信息.xls");
        workbook.write(fos);
        fos.close();


    }

}
