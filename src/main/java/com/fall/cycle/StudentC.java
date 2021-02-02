package com.fall.cycle;

/**
 * @author xql132@zcsmart.com
 * @date 2021/2/2
 * @time 11:20
 * @description
 */
public class StudentC {

    private StudentA studentA;

    public StudentC(StudentA studentA) {
        this.studentA = studentA;
    }

    public StudentC() {
    }

    public StudentA getStudentA() {
        return studentA;
    }

    public void setStudentA(StudentA studentA) {
        this.studentA = studentA;
    }
}
