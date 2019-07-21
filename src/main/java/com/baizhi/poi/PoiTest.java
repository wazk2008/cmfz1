package com.baizhi.poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class PoiTest {
    public static void main(String[] args) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        CellRangeAddress cellAddresses = new CellRangeAddress(0,0,0,4);
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy-MM-dd HH:mm:ss");
        HSSFCellStyle cellStyle = workbook.createCellStyle();

        cellStyle.setDataFormat(format);
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setColor(Font.COLOR_RED);
        cellStyle.setFont(font);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        HSSFSheet sheet = workbook.createSheet("测试表");
        sheet.addMergedRegion(cellAddresses);
        sheet.setColumnWidth(0,40*256);
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
//        cell.setCellValue("编号编号编号编号编号编号编号编号");
        cell.setCellValue(new Date());
        cell.setCellStyle(cellStyle);
        workbook.write(new File("d:/test.xls"));
        System.out.println("over");

    }
}
