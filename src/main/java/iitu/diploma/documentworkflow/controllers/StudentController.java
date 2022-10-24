package iitu.diploma.documentworkflow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/stud")
public class StudentController {

    @GetMapping(value = "/about")
    public String about(){
        return "studAbout";
    }
}
