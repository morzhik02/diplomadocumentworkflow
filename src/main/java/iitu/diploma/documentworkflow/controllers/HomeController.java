package iitu.diploma.documentworkflow.controllers;

import iitu.diploma.documentworkflow.db.DBManager;
import iitu.diploma.documentworkflow.db.DocTypes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @GetMapping(value = "/docform")
    public String home(Model model){
        ArrayList<DocTypes> docTypes = DBManager.getDocTypes();
        model.addAttribute("docs", docTypes);
        return "docForm";
    }

    @GetMapping(value = "/about")
    public String about(){
        return "about";
    }

    @PostMapping(value = "/addDoc")
    public String addDoc(@RequestParam(name = "doc_type", defaultValue = "No") String name){
        DBManager.addDoc(new DocTypes(1L, name));
        System.out.println("ДОБАВИЛОСЬ");
        return "redirect:/about";
    }

}
