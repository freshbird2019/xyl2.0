package xyl.cct.controller;

import javafx.scene.chart.ValueAxis;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.pojo.Xy;
import xyl.cct.service.ClazzService;
import xyl.cct.service.XyService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ClazzController {
    @Resource(name = "ClazzService")
    private ClazzService clazzService;
    @Resource(name = "xyService")
    private XyService xyService;

    /*
    获取班级人数
     */
    @ResponseBody
    @RequestMapping(value = "/getClassNumById",method = RequestMethod.GET)
    public int getClassNumById(
            @RequestParam(value = "classid",required =false) int id){
        List<Xy> list=clazzService.getAllXy2(id);
        int num=list.size();
        return num;
    }

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
