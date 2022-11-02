package iitu.diploma.documentworkflow.controllers;

import iitu.diploma.documentworkflow.beans.TestBean;
import iitu.diploma.documentworkflow.db.DBManager;
import iitu.diploma.documentworkflow.db.Document;
import iitu.diploma.documentworkflow.entities.Documents;
import iitu.diploma.documentworkflow.entities.Students;
import iitu.diploma.documentworkflow.services.StudentService;
import iitu.diploma.documentworkflow.services.impl.DocumentServiceImpl;
import iitu.diploma.documentworkflow.services.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private DocumentServiceImpl documentService;

    @GetMapping(value = "/")
    public String home(Model model){
        List<Documents> documents = documentService.getAllDocs();
        model.addAttribute("docs", documents);

        /*List<Students> students = documentService.getAllStudents();
        model.addAttribute("students", students);*/

        return "docForm";
    }

    @GetMapping(value = "/about")
    public String about(){
        return "about";
    }

    @PostMapping(value = "/adddoc")
    public String addDoc(@RequestParam(name = "docName") String docName,
                         @RequestParam(name = "studLogin") int studLogin){
        System.out.println("DOCNAME: " + docName + ", STUDENT:" + studLogin);
        //Students students = documentService.getStudent(studId);
        //if(students != null){
            documentService.addDoc(new Documents(null, docName, null, studLogin, 0L, "Создано"));
        //}
        return "redirect:/";
    }

    @GetMapping(value = "/details/{id}")
    public String details(Model model, @PathVariable(name = "id") Long id){
        Documents document = documentService.getId(id);
        model.addAttribute("document", document);
        return "details";
    }

    @PostMapping(value = "/savedoc")
    public String saveDoc(@RequestParam(name = "docId") Long docId,
                          @RequestParam(name = "status") String status){
        Documents document = documentService.getId(docId);
        if (document != null){
            document.setStatus(status);
            documentService.saveDoc(document);
        }
        return "redirect:/";
    }

    @PostMapping(value = "/deletedoc")
    public String deleteDoc(@RequestParam(name = "docId") Long docId){
        Documents document = documentService.getId(docId);
        if (document != null){
            documentService.deleteDoc(document);
        }
        return "redirect:/";
    }

}
