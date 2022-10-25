package iitu.diploma.documentworkflow.controllers;

import iitu.diploma.documentworkflow.beans.TestBean;
import iitu.diploma.documentworkflow.db.DBManager;
import iitu.diploma.documentworkflow.db.Document;
import iitu.diploma.documentworkflow.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/")
    public String home(Model model){
        ArrayList<Document> documents = DBManager.getDocuments();
        studentService.setData("Marzhan");
        String text = studentService.getData();
        model.addAttribute("docs", documents);
        model.addAttribute("text", text);
        return "docForm";
    }

    @GetMapping(value = "/about")
    public String about(){
        return "about";
    }

    @PostMapping(value = "/adddoc")
    public String addDoc(@RequestParam(name = "doc_name") String name,
                        @RequestParam(name = "stud_id", defaultValue = "0") int studId){
        DBManager.addDoc(new Document(null, name, 0, studId, 0, "Создано"));
        return "redirect:/";
    }

    @GetMapping(value = "/details/{id}")
    public String details(Model model, @PathVariable(name = "id") Long id){
        Document document = DBManager.getDocument(id);
        model.addAttribute("document", document);
        return "details";
    }


}
