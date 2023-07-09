package com.security.SpringSecurityLearning.student;

public class Student {
    private Integer student_id;
    private String student_name;
    public Student(Integer student_id, String student_name) {
        this.student_id = student_id;
        this.student_name = student_name;
    }

    public Student(){}
    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
}
