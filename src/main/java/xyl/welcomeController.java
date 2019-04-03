package xyl;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xyl.dyx.POJO.ManagerEntity;

import javax.servlet.http.HttpServletResponse;

@Controller
public class welcomeController {

    @RequestMapping(value = "/welcome")
    public ModelAndView welcome(){
        return new ModelAndView("welcome");
    }


    @ResponseBody
    @RequestMapping(value = "/test")
    public String test() {
        ManagerEntity gly = new ManagerEntity();

        gly.setId("gly50");
        gly.setName("cct");
        gly.setPassword("123");

        Gson gson = new Gson();
        return gson.toJson(gly);

    }
}
