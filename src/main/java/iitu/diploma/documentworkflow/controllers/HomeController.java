package iitu.diploma.documentworkflow.controllers;

import iitu.diploma.documentworkflow.entities.Documents;
import iitu.diploma.documentworkflow.entities.Users;
import iitu.diploma.documentworkflow.services.UserService;
import iitu.diploma.documentworkflow.services.impl.DocumentServiceImpl;
import iitu.diploma.documentworkflow.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private DocumentServiceImpl documentService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/doc")
    public String home(Model model){
        model.addAttribute("currentUser", getUserData());

        List<Documents> documents = documentService.getAllDocs();
        model.addAttribute("docs", documents);

        /*List<Students> students = documentService.getAllStudents();
        model.addAttribute("students", students);*/
        return "doc";
    }

    @GetMapping(value = "/main")
    public String about(Model model){
        model.addAttribute("currentUser", getUserData());

        return "main";
    }

    @GetMapping(value = "/doclist")
    @PreAuthorize("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_ADMIN')")
    public String doclist(Model model){
        model.addAttribute("currentUser", getUserData());

        List<Documents> documents = documentService.getAllDocs();
        model.addAttribute("docs", documents);
        return "docForm";
    }

    @PostMapping(value = "/adddoc")
    public String addDoc(@RequestParam(name = "docName") String docName,
                         @RequestParam(name = "studLogin") int studLogin){
        System.out.println("DOCNAME: " + docName + ", STUDENT:" + studLogin);
        //Students students = documentService.getStudent(studId);
        //if(students != null){
            documentService.addDoc(new Documents(null, docName, null, studLogin, 0L, "Создано"));
        //}
        return "redirect:/home";
    }

    @GetMapping(value = "/details/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public String details(Model model, @PathVariable(name = "id") Long id){
        model.addAttribute("currentUser", getUserData());

        Documents document = documentService.getId(id);
        model.addAttribute("document", document);
        return "details";
    }

    @PostMapping(value = "/savedoc")
    @PreAuthorize("hasAnyRole('ROLE_EMPLOYEE', 'ROLE_ADMIN')")
    public String saveDoc(@RequestParam(name = "docId") Long docId,
                          @RequestParam(name = "status") String status){
        Documents document = documentService.getId(docId);
        if (document != null){
            document.setStatus(status);
            documentService.saveDoc(document);
        }
        return "redirect:/doclist";
    }

    @PostMapping(value = "/deletedoc")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteDoc(@RequestParam(name = "docId") Long docId){
        Documents document = documentService.getId(docId);
        if (document != null){
            documentService.deleteDoc(document);
        }
        return "redirect:/doclist";
    }

    @GetMapping(value = "/403")
    public String accessDenied(Model model){
        model.addAttribute("currentUser", getUserData());

        return "403";
    }

    @GetMapping(value = "/login")
    public String login(Model model){
        model.addAttribute("currentUser", getUserData());

        return "login";
    }

    @GetMapping(value = "/profile")
    @PreAuthorize("isAuthenticated()")
    public String profile(Model model){
        model.addAttribute("currentUser", getUserData());
        return "profile";
    }

    private Users getUserData(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User secUser = (User)authentication.getPrincipal();
            Users myUser = userService.getUserByEmail(secUser.getUsername());
            return myUser;
        }
        return null;
    }
}
