
package resumeproject.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import resumeproject.demo.dalrepositories.Dalemprepository;
import resumeproject.demo.modelzlayer.EmploymentData;

import javax.validation.Valid;


@Controller
public class MainController
{

    @Autowired
    Dalemprepository dalemprepository;



    @GetMapping("/index")
    public String indexPage(Model model)
    {

        model.addAttribute("welcomemessage","Welcome to this book DB");
        return "index";
    }


    @GetMapping("/addemployment")
    public String addEmployment(Model model)
    {
        model.addAttribute("newemp", new EmploymentData());

        model.addAttribute("addnewemployeemessage","please add Employee");
        return "addemployment";
    }

    @PostMapping("/addemployment")
    public String postProduct( @ModelAttribute("newemp") EmploymentData emp)
    {
        dalemprepository.save(emp); // save it to the db
        return "employeeconfirmation";
    }


   /* @GetMapping("/displayallbooks")
    public String displayBooks(Model model)
    {
        Iterable<Book> bookList = bookRepository.findAll();
        model.addAttribute("books",bookList);
        return "displayallbooks";


    }*/
}
