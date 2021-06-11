package org.perscholas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("courses")
public class CourseController {


    @GetMapping("registercourse")
    public String registerCourse(){
        return "registercourse";
    }

}
