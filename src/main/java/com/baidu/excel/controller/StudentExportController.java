package com.baidu.excel.controller;


import com.baidu.excel.pojo.Student;
import com.baidu.excel.service.StudentExportService;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pym
 * @Date: 2019-10-11 0:46
 * @Version 1.0
 */
@Controller
public class StudentExportController {
    @Autowired
    private StudentExportService studentExportService;
    @RequestMapping(value="/excel/export")
    public void exportExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("1","pym","21"));
        list.add(new Student("2","lls","18"));
        list.add(new Student("1","cmm","5"));
        HSSFWorkbook wb = studentExportService.export(list);
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition","attachment;filename=student.xls");
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
