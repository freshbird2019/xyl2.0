package xyl.dyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import xyl.dyx.POJO.ActivityEntity;
import xyl.dyx.service.activityEntityService;

import javax.annotation.Resource;

@Controller
public class manageActivity {
    @Resource(name = "activityEntityService")
    private activityEntityService acService;

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
}
