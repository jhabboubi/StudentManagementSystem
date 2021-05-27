package org.perscholas.controllers;

import lombok.extern.java.Log;
import org.perscholas.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.perscholas.services.StudentService;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("student")
@Log
@SessionAttributes({"student"})

public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {this.studentService = studentService; }

    @ModelAttribute("student")
    public Student initStudent(){
        return new Student();
    }

    @GetMapping("/register")
    public String register(){
        return "registerstudent";
    }

    @PostMapping("/submit")
    public String newStudent(@ModelAttribute("student") @Valid Student student, BindingResult result, Model model ){

            Student s = studentService.addNewStudent(student);
            model.addAttribute("studentTemp", s);
            System.out.println(s);
            return "displaystudents";
    }

    @GetMapping("/showstudents")
    public String showStudents(@ModelAttribute("student") @Valid Student student, BindingResult result, Model model ){

            List<Student> s = studentService.getStudents();
            model.addAttribute("studentTemp", s);
            System.out.println(s);
        return "displaystudents";
    }

}
