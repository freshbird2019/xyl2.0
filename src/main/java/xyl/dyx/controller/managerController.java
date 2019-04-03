package xyl.dyx.controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.service.LyService;
import xyl.dyx.POJO.ActivityEntity;
import xyl.dyx.POJO.ManagerEntity;
import xyl.dyx.service.activityEntityService;
import xyl.dyx.service.glyEntityService;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletResponse;

@Controller
public class managerController {

    @Resource(name = "glyEntityService")
    private glyEntityService glyService;

    @ResponseBody
    @RequestMapping(value = "/checkLogin")
    public boolean checkLogin(@RequestParam String id, @RequestParam String pw, HttpServletResponse response) {

        ManagerEntity gly = new ManagerEntity();
        gly.setId(id);
        gly.setPassword(pw);
        if(glyService.ifCorrect(gly)) {//存在则进入主界面
            return true;
        } else {
            return false;
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
