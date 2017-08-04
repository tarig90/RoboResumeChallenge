
package resumeproject.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import resumeproject.demo.modelzlayer.EmploymentData;

import javax.validation.Valid;


@Controller
public class MainController
{

   // @Autowired
   // EmpRepositry empRepositry;



    @GetMapping("/index")
    public String indexPage(Model model)
    {

        model.addAttribute("welcomemessage","Welcome to this book DB");
        return "index";
    }


    @GetMapping("/addmployment")
    public String addEmployment(Model model)
    {
        model.addAttribute("newbook", new EmploymentData());

        model.addAttribute("addnewemployee","please add Employee");
        return "addemployment";
    }

    @PostMapping("/addbook")
    public String postProduct(@Valid @ModelAttribute("newbook") EmploymentData emp, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()){
            return "addbook";
        }
        //resumeproject.demo.EmployeeRepositry.save(book); // save it to the db
        return "bookadditionconfirmation";
    }


   /* @GetMapping("/displayallbooks")
    public String displayBooks(Model model)
    {
        Iterable<Book> bookList = bookRepository.findAll();
        model.addAttribute("books",bookList);
        return "displayallbooks";


    }*/
}