package com.nhnacademy.edu.springboot.studentmanagement.controller;

import com.nhnacademy.edu.springboot.studentmanagement.entity.Student;
import com.nhnacademy.edu.springboot.studentmanagement.entity.User;
import com.nhnacademy.edu.springboot.studentmanagement.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/register.do")
    public String register(@ModelAttribute Student student, Model model, HttpServletRequest request) {
        studentService.register(student);
        model.addAttribute("user", request.getSession(false).getAttribute("user"));
        return "redirect:/student/list.do";
    }

    @GetMapping("/register.do")
    public String registerForm(Model model, HttpServletRequest request) {
        model.addAttribute("user", request.getSession(false).getAttribute("user"));
        model.addAttribute("student", new Student());
        return "student/register";
    }

    @PostMapping("/delete.do")
    public String delete(@ModelAttribute("id") String id) {
        studentService.delete(id);
        return "redirect:/student/list.do";
    }

    @GetMapping("/list.do")
    public String list(Model model, HttpServletRequest request) {
        List<Student> studentList = studentService.getStudentList();
        model.addAttribute("studentList", studentList);
        model.addAttribute("user", request.getSession(false).getAttribute("user"));
        return "student/List";
    }


}
