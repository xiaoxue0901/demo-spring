package com.fall.cycle;

/**
 * @author xql132@zcsmart.com
 * @date 2021/2/2
 * @time 11:20
 * @description
 */
public class StudentA {
    private StudentB studentB;

    public StudentA() {
    }

    public StudentA(StudentB studentB) {
        this.studentB = studentB;
    }

    public StudentB getStudentB() {
        return studentB;
    }

    public void setStudentB(StudentB studentB) {
        this.studentB = studentB;
    }
}
