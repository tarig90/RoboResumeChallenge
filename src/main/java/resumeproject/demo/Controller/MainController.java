
package resumeproject.demo.Controller;


import groovy.transform.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import resumeproject.demo.dalrepositories.Dalemprepository;
import resumeproject.demo.modelzlayer.EmploymentData;
import sun.util.calendar.BaseCalendar;

import java.text.ParseException;
import javax.validation.Valid;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


@Controller
public class MainController
{



    Date date= new Date();
    DateFormat df= new SimpleDateFormat("MM/dd/yyyy");

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
    public String postProduct(@ModelAttribute("newemp") EmploymentData emp, BindingResult bindResult, Model nModel)
    {

        EmploymentData emplData =  new EmploymentData();

        if (bindResult.hasErrors()) {
            return "addemployment";
        }
        System.out.println(emp.getName());

        try {
            if(emp.getEndDate()== null)
            {
               emp.setEndDate(df.format(date));
            }

            long test;
            Date date1 = df.parse(emp.getStartDate());
            Date date2 = df.parse(emp.getEndDate());

            long diff = date2.getTime() - date1.getTime();
            test = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            emplData.setNumOfDays(test);
            emp.setNumOfDays(test);

        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        nModel.addAttribute("cal", emplData);

        dalemprepository.save(emp);


        return "employeeconfirmation";
    }

    @GetMapping("/displaydetails")
    public String displayBooks(Model model)
    {

        Iterable<EmploymentData> EmployeeList = dalemprepository.findAll();

        model.addAttribute("employeez", EmployeeList);


        return "displaydetails";
    }

}
