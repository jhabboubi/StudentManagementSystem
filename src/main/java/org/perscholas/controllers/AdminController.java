package org.perscholas.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("console")
public class AdminController {
    @GetMapping("/getallstudent")
    public String getUsers(Model model){

        return "getallstudent";
    }

    @PreAuthorize("hasAuthority('WRITE')")
    @GetMapping("/getstudentbyid")
    public String getStudentById(){

        return "getstudentbyid";
    }



}
