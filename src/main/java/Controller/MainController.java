
package Controller;

import ModelsLayer.EmploymentDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.ui.Model.*;

@Controller
public class MainController
{

    @GetMapping("/")
    public String showIndex(Model model){
        String myMessage = "Welcome to the employee App";
        model.addAttribute("message", myMessage);
        return "index";
    }

    @GetMapping("/addemployment")
    public String addProduct(Model model)
    {

        model.addAttribute("newemployee", new EmploymentDetails());
    return "addemployment";

    }
}
