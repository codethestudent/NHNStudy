package com.nhnacademy.edu.springboot.student.adapter.in;

import com.nhnacademy.edu.springboot.student.domain.Student;
import com.nhnacademy.edu.springboot.student.domain.StudentSevice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {
    private final StudentSevice studentService;

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/{id}")
    public ResultResponse deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return null;
    }
}
