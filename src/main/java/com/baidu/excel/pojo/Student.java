package com.baidu.excel.pojo;

/**
 * @Author: pym
 * @Date: 2019-10-11 1:14
 * @Version 1.0
 */
public class Student {
    private String sno;
    private String sname;
    private String sage;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    public Student(String sno, String sname, String sage) {
        this.sno = sno;
        this.sname = sname;
        this.sage = sage;
    }
}
