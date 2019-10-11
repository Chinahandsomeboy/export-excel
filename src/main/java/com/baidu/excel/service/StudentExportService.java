package com.baidu.excel.service;

import com.baidu.excel.pojo.Student;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: pym
 * @Date: 2019-10-11 1:10
 * @Version 1.0
 */
@Service
public class StudentExportService {
    String[] excelHeader = { "Sno", "Name", "Age"};
    public HSSFWorkbook export(List<Student> list) {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("student");
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        for (int i =0;i<excelHeader.length;i++){
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(excelHeader[i]);
            cell.setCellStyle(style);
            sheet.autoSizeColumn(i);
        }
        for (int i = 0;i<list.size();i++){
            row = sheet.createRow(i+1);
            Student student = list.get(i);
            row.createCell(0).setCellValue(student.getSno());
            row.createCell(1).setCellValue(student.getSname());
            row.createCell(2).setCellValue(student.getSage());
        }
        return wb;
    }
}
