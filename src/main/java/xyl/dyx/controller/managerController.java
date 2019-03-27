package xyl.dyx.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.service.LyService;
import xyl.dyx.POJO.ActivityEntity;
import xyl.dyx.POJO.ManagerEntity;
import xyl.dyx.service.activityEntityService;
import xyl.dyx.service.glyEntityService;

import javax.annotation.Resource;
import javax.jws.WebParam;

@Controller
public class managerController {

    @Resource(name = "glyEntityService")
    private glyEntityService glyService;



    @RequestMapping("/login")
    public ModelAndView login() {

        ModelAndView mv =new ModelAndView("glyLogin","command",new ManagerEntity());

        mv.addObject("msg","欢迎登陆");

        return mv;
    }

    @RequestMapping(value = "/checkLogin")
    public String checkLogin(@ModelAttribute ManagerEntity gly, ModelMap model) {

        if(glyService.ifCorrect(gly)) {//存在则进入主界面
            return "glyHome";
        } else {
            model.addAttribute("msg","登陆失败，请检查信息");
            return "redirect:/login";
        }

    }

    /*
    * 管理员主界面
    * 针对用户的选择选择不同的控制器
    * 跳转界面进行操作
     */
    @RequestMapping(value = "/gly",method = RequestMethod.GET)
    public ModelAndView gly() {
        return new ModelAndView("glyHome");
    }







}
