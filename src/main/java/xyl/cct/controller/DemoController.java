
package xyl.cct.controller;



import xyl.cct.pojo.Xy;
import xyl.cct.pojo.Ly;
import xyl.cct.service.LyService;
import xyl.cct.service.XyService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.sql.Timestamp;


@Controller

public class DemoController {


    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "hello");
        mv.setViewName("index");
        return mv;
    }

}

