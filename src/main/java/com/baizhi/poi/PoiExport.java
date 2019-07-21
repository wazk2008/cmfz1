package com.baizhi.poi;

import com.baizhi.entity.User;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class PoiExport {

    public static void main(String[] args) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy-MM-dd HH:mm:ss");

        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        CellRangeAddress cellAddresses = new CellRangeAddress(0, 0, 0, 4);
        HSSFSheet sheet = workbook.createSheet("用户信息表");
        sheet.addMergedRegion(cellAddresses);
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(cellStyle);
        cell.setCellValue("用户详细信息");

        HSSFRow row1 = sheet.createRow(1);
        String[] arr = {"编号","姓名","电话","性别","生日"};
        for (int i = 0; i < arr.length; i++) {
            HSSFCell cell1 = row1.createCell(i);
            cell1.setCellValue(arr[i]);
            cell1.setCellStyle(cellStyle);
        }

        ArrayList<User> users = new ArrayList<User>();
        for (int i = 0; i <10 ; i++) {
            User user = new User();
            user.setId(i+"");
            user.setUsername("张三"+i);
            user.setMobile(i+"");
            user.setSex("男");
            user.setRegistDate(new Date());
            users.add(user);
        }

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            HSSFRow row2 = sheet.createRow(i + 2);

            HSSFCell cell0 = row2.createCell(0);
            cell0.setCellValue(user.getId());

            HSSFCell cell1 = row2.createCell(1);
            cell1.setCellValue(user.getUsername());

            HSSFCell cell2 = row2.createCell(2);
            cell2.setCellValue(user.getMobile());

            HSSFCell cell3 = row2.createCell(3);
            cell3.setCellValue(user.getSex());

            HSSFCell cell4 = row2.createCell(4);
            cell4.setCellValue(user.getRegistDate());
            cell4.setCellStyle(cellStyle);
        }


        workbook.write(new File("d:/用户信息.xls"));

    }

}
