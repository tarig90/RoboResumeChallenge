
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
import java.lang.reflect.Array;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;


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

//
//    @PostMapping("/enterinformation")
//    public String postinfo(@Valid @ModelAttribute("newinfo") EmploymentData otherinfo, BindingResult bindingResult, Model newmodel) {
//
//        EmploymentData employeInfo =  new EmploymentData();
//
//        if (bindingResult.hasErrors())
//        {
//            return "addinfo";
//        }
//        System.out.println(otherinfo.getName());
//
//        try {
//
//            if(otherinfo.getEnddate()!=null)
//            {
//                otherinfo.setEndDate(df.format(date));
//            }
//
//            long test;
//            Date date1 = df.parse(otherinfo.getStartdate());
//            Date date2 = df.parse(otherinfo.getEnddate());
//
//            long diff = date2.getTime() - date1.getTime();
//            test = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
//            employeInfo.setDays(test);
//            otherinfo.setDays(test);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        newmodel.addAttribute("dates", employeInfo);
//
//        employeRepository.save(otherinfo);
//
//
//        return "resultinfo";
//    }



    @GetMapping("/displaydetails")
    public String displayBooks(Model model)
    {
        Iterable<EmploymentData> EmployeeList = dalemprepository.findAll();

        model.addAttribute("employeez", EmployeeList);

        return "displaydetails";
    }




}
