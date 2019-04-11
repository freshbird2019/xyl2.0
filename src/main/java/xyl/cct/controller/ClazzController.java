package xyl.cct.controller;

import javafx.scene.chart.ValueAxis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.pojo.Xy;
import xyl.cct.service.ClazzService;
import xyl.cct.service.XyService;

import javax.annotation.Resource;

@Controller
public class ClazzController {
    @Resource(name = "ClazzService")
    private ClazzService clazzService;
    @Resource(name = "xyService")
    private XyService xyService;

    /*
    申请班级时，获取所有班级信息
     */
    @RequestMapping(value = "/getAllClazz",method = RequestMethod.GET)
    public ModelAndView getAllClazz(int id, Model model){
        Xy xy=xyService.getXyById(id);
        System.out.println(xy.getName());
        model.addAttribute("nowinxy",xy);
        ModelAndView mv = new ModelAndView();
        mv.addObject("clazz",clazzService.getAllCla());
        mv.setViewName("classdisplay");
        return mv;
    }

    /*
    申请加入该班级
     */
    @RequestMapping(value = "/applyClass.do")
    public String apllyClass(int cid,int xid,Model model){
        Xy xy=xyService.getXyById(xid);
        System.out.println(xy.getName()+"申请班级"+cid);
        model.addAttribute("nowinxy",xy);
        return "xyHome";
    }
}
