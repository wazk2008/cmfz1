package com.baizhi.poi;

import com.baizhi.entity.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class PoiImport {
    public static void main(String[] args) throws Exception {

        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File("d:/用户信息.xls")));
        HSSFSheet sheet = workbook.getSheet("用户信息表");
        ArrayList<User> list = new ArrayList<>();
        for (int i = 2; i <= sheet.getLastRowNum(); i++) {
            User user = new User();

            HSSFRow row = sheet.getRow(i);

            HSSFCell cell0 = row.getCell(0);
            String id = cell0.getStringCellValue();
            user.setId(id);

            HSSFCell cell1 = row.getCell(1);
            String name = cell1.getStringCellValue();
            user.setUsername(name);

            HSSFCell cell2 = row.getCell(2);
            String mobile = cell2.getStringCellValue();
            user.setMobile(mobile);

            HSSFCell cell3 = row.getCell(3);
            user.setSex(cell3.getStringCellValue());

            HSSFCell cell4 = row.getCell(4);
            user.setRegistDate(cell4.getDateCellValue());

            list.add(user);
        }

        for (User user : list) {
            System.out.println(user);
        }


    }
}
