package com.security.SpringSecurityLearning.student;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private static final List<Student> students = Arrays.asList(
            new Student(1, "vitalii"),
            new Student(2, "vadim"),
            new Student(3, "roman")
    );

    @GetMapping()
    public List<Student> allStudents(){
        return students;
    }

    @GetMapping("/{id}")
    public Student getOneStudent(@PathVariable Integer id){
        return students.stream()
                .filter(student -> id.equals(student.getStudent_id()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Does not exist"));
    }
}
