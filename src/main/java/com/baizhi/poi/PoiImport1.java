package com.baizhi.poi;

import com.baizhi.entity.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

public class PoiImport1 {
    public static void main(String[] args) throws Exception {

        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File("d:/用户信息.xls")));
        HSSFSheet sheet = workbook.getSheet("用户信息表");
        ArrayList<User> list = new ArrayList<>();
        for (int i = 2; i <= sheet.getLastRowNum(); i++) {
            User user = new User();

            HSSFRow row = sheet.getRow(i);

//            Class<? extends User> userClass = (Class<? extends User>) user.getClass();
//            Class<User> userClass = User.class;
//            拿到类对象
            Class<?> userClass = Class.forName("com.baizhi.entity.User");
            Field[] fields = userClass.getDeclaredFields();
//            拿到类中的所有属性
            for (int j=0;j<fields.length;j++) {
                Field field = fields[j];
//                拿到每一个属性的名字
                String fieldName = field.getName();
                //调用set方法
                //获取set方法的方法名
                String methodName = "set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                HSSFCell cell = row.getCell(j);
                if("registDate".equals(fieldName)){
                    Date date = cell.getDateCellValue();
                    //调用set方法
                    //获取set方法的方法名

//                第一个参数：方法名     第二个参数：set方法的参数类型
                    Method method = userClass.getDeclaredMethod(methodName, Date.class);
//                set方法的调用，第一个参数：调用者    第二个参数：调用时传入的参数
                    method.invoke(user,date);
                }else{
                    String value = cell.getStringCellValue();

//                第一个参数：方法名     第二个参数：set方法的参数类型
                    Method method = userClass.getDeclaredMethod(methodName, String.class);
//                set方法的调用，第一个参数：调用者    第二个参数：调用时传入的参数
                    method.invoke(user,value);
                }
            }
            list.add(user);
        }

        for (User user : list) {
            System.out.println(user);
        }


    }
}
