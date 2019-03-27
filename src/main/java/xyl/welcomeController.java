package xyl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class welcomeController {

    @RequestMapping(value = "/welcome")
    public ModelAndView welcome(){
        return new ModelAndView("welcome");
    }
}
