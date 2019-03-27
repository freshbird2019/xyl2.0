package xyl.dyx.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.service.LyEntityService;
import xyl.dyx.POJO.ActivityEntity;
import xyl.dyx.POJO.ManagerEntity;
import xyl.dyx.service.activityEntityService;
import xyl.dyx.service.glyEntityService;

import javax.annotation.Resource;
import javax.jws.WebParam;

@Controller
public class managerController {

    @Resource(name = "activityEntityService")
    private activityEntityService acService;

    @Resource(name = "glyEntityService")
    private glyEntityService glyService;


    /*
    * login
    * 出于不知道什么原因，没办法在service层完成验证操作
    * 转移到controller层
     */
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


    /*
    * 获取所有活动信息
     */
    @RequestMapping(value = "/activityPg",method = RequestMethod.GET)
    public ModelAndView activityPg() {
        ModelAndView mv = new ModelAndView("displayAc");
        mv.addObject("activities",acService.getAllActivities());
        return mv;
    }
    /*
    * 删除活动
     */
    @RequestMapping(value = "/deleteAc.do")
    public String delete(int id) {


        if(acService.deleteActivityEntity(id)) {
            System.out.println("delete successfully");
        } else {
            System.out.println("o ho");
        }

        return "redirect:/activityPg";
    }

    /*
    * 添加活动
     */
    @RequestMapping(value = "/addAc.do")
    public ModelAndView add() {
        return new ModelAndView("addAc","command",new ActivityEntity());
    }

    @RequestMapping(value = "/submitAcInfo.do")
    public String submitAcInfo(@ModelAttribute ActivityEntity ac) {
        if(acService.addActivityEntity(ac)) {
            System.out.println("add new ac " + ac.getName());
        } else {
            System.out.println("add failed");
        }
        return "redirect:/activityPg";
    }

    /*
    * 管理留言信息
    */
    @RequestMapping(value = "/glLy")
    public ModelAndView glLy() {
        ModelAndView mv = new ModelAndView("glLy");

        mv.addObject("lyList",)

        return mv;

    }


}
