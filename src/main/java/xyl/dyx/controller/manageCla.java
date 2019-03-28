package xyl.dyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.dao.ClazzDao;
import xyl.cct.pojo.Clazz;
import xyl.cct.pojo.Xy;
import xyl.cct.service.ClazzService;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.List;

@Controller
public class manageCla {

    @Resource(name = "ClazzService")
    ClazzService claSer;

    // 管理班级界面
    @RequestMapping("/glClass")
    public ModelAndView glCla() {

        ModelAndView mv = new ModelAndView("glClass");
        // 获取班级列表
        mv.addObject("classList",claSer.getAllCla());

        // 获取申请人数
        mv.addObject("applyMap",claSer.getApplyNum());
        return mv;
    }

    // 添加班级
    @RequestMapping("/addClass")
    public String allClass(@ModelAttribute Clazz cla) {

        if(claSer.addCla(cla)) {

            System.out.println("add new class ");

        } else {

            System.out.println("add failure");

        }

        return "redirect:/glClass";

    }

    // 查看班级成员信息，id是查看班级的id
    @RequestMapping("/displayMember")
    public ModelAndView displayMember(int id) {

        List<Xy> xyList = claSer.getAllXy(id);

        ModelAndView mv = new ModelAndView("displayMember");

        mv.addObject("xyList",xyList);

        return mv;
    }

}
