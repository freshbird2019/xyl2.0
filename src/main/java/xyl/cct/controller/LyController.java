package xyl.cct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.pojo.Ly;
import xyl.cct.pojo.Xy;
import xyl.cct.service.LyService;
import xyl.cct.service.XyService;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Controller
public class LyController {
    @Resource(name = "lyService")
    private LyService lyService;
    @Resource(name = "xyService")
    private XyService xyService;

    /*
    跳转到添加留言页面
     */
    @RequestMapping(value = "/addLy.do")
    public ModelAndView addLy(int id){
        Xy xy=xyService.getXyById(id);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("addly");
        mv.addObject("nowinxy",xy);
        return mv;
    }

    /*
    添加留言
    发送留言给管理员审核，跳转到成功页面
     */
    @RequestMapping(value = "/XyaddLy.do",method = RequestMethod.POST)
    public String XyaddLy(int id,Ly l,Model model){
        Xy xy=xyService.getXyById(id);
        model.addAttribute("nowinxy",xy);
        String s=l.getInfo();System.out.println("添加留言"+s);
        //SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp time=new Timestamp(System.currentTimeMillis());
        //怎么设置留言人学号
        l.setXyByLyxid(xy);
        l.setLydate(time);
        l.setState(0);
        lyService.addLy(l);
        return "xyHome";
    }
    /*
    删除留言信息
     */
    @RequestMapping(value = "/delete.do")
    public String deleteLy(int id){
        System.out.println(id);
        lyService.deleteLy(id);
        return "redirect:/getAllLy";
    }


    /*
     *管理员从数据库中拉取所有留言
     */
    @RequestMapping(value = "/getAllLy")
    public ModelAndView getAllLyEntity(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("lys",lyService.getAllLy());
        mv.setViewName("lydisplay");
        return mv;
    }

    /*
     *x校友从数据库中拉取所有留言
     */
   @RequestMapping(value = "/XygetAllLy")
    public ModelAndView getAllLy(int id, Model model){
        Xy xy=xyService.getXyById(id);
        model.addAttribute("nowinxy",xy);
        ModelAndView mv=new ModelAndView();
        mv.addObject("lys",lyService.getAllLy());
        mv.setViewName("xylydisplay");
        return mv;
    }
}
