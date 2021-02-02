package com.fall.cycle;

/**
 * @author xql132@zcsmart.com
 * @date 2021/2/2
 * @time 11:20
 * @description
 */
public class StudentB {
    private StudentC studentC;

    public StudentB(StudentC studentC) {
        this.studentC = studentC;
    }

    public StudentB() {
    }

    public StudentC getStudentC() {
        return studentC;
    }

    public void setStudentC(StudentC studentC) {
        this.studentC = studentC;
    }
}
