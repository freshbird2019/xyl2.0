package xyl.dyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.service.LyService;

import javax.annotation.Resource;

@Controller
public class manageLy {


    @Resource(name = "lyService")
    private LyService lyService;

    /*
     * 管理留言信息
     */
    @RequestMapping(value = "/glLy")
    public ModelAndView glLy() {
        ModelAndView mv = new ModelAndView("glLy");

        mv.addObject("lyList",lyService.getAllLy());

        return mv;

    }

    @RequestMapping(value = "/deleteLy.do")
    public String deleteLy(int id) {

        if(lyService.deleteLy(id)) {
            System.out.println("delete message "+id);
        } else {
            System.out.println("wuhu, delete ly failed");
        }

        return "redirect:/glLy";
    }

    @RequestMapping("/admitLy")
    public String addLy(int id) {

        if(lyService.updateState(id)) {
            System.out.println("update id "+ id);
        }else {
            System.out.println("update failed");
        }

        // 去dao层update数据
        return "redirect:/glLy";
    }
}

