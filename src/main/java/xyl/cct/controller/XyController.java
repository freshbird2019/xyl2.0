package xyl.cct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.pojo.Xy;
import xyl.cct.service.XyService;

import javax.annotation.Resource;

@Controller
public class XyController {
    @Resource(name = "xyService")
    private XyService xyService;

    /*
    检查校友登录
     */
    @RequestMapping(value = "/checkXyLogin.do")
    public ModelAndView checkLogin(Xy xy,Model model) {
        ModelAndView mv = new ModelAndView();
        int nowid=xyService.ifCorrect(xy);
        if(nowid>0) {//存在则进入主界面
            mv.setViewName("xyHome");
            xy.setXid(nowid);
            model.addAttribute("nowinxy",xy);
        } else {
            mv.addObject("msg", "登录失败！");
            mv.setViewName("xylogin");
        }
        return mv;
    }

    /*
   获取所有校友信息
    */
    @RequestMapping(value = "/getAllXy", method = RequestMethod.GET)
    public ModelAndView getAllXy() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("xys",xyService.getAllXy());
        mv.setViewName("xydisplay");
        return mv;
    }

    /*
    获取与当前校友同班的校友信息
     */
   /* @RequestMapping(value = "/getXyByClassId" ,method=RequestMethod.GET)
    public ModelAndView getXyByClassId(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("xys",xyService)
        mv.setViewName("xxydisplay");
        return mv;
    }*/

    /*
    修改校友信息,
    将要修改的校友信息传过来
    跳转到updatexy界面修改
     */
    @RequestMapping(value = "/updateXy.do")
        public String updateXy(int id, Model model){
            System.out.println(id);
            Xy x=xyService.getXyById(id);
        // System.out.println(x.getId());
        model.addAttribute("xy",x);
        return "updatexy";
    }

    /*
    修改校友信息，
    成功后回到主界面
     */
    @RequestMapping("/update.do")
    public String update(Xy x){
        System.out.println("修改校友信息"+x.getName());
        xyService.updateXyEntity(x);
        return "redirect:/getAllXy";
    }

    /*
    修改校友信息，
    成功后回到主界面
     */
    @RequestMapping("/updateNowin.do")
    public String updateNowin(Xy x,Model model){
        System.out.println("修改校友信息"+x.getName());
        xyService.updateXyEntity(x);
        model.addAttribute("nowinxy",x);
        return "xyHome";
    }


    /*
    校友注册
     */
    @RequestMapping(value = "/register.do",method = RequestMethod.POST)
    public String Xyregister(Xy xy){
        System.out.println("注册新校友"+xy.getName());
        /*int index=xyService.getMaxId()+1;
        xy.setXyId(index);*/
        xy.setState(0);
        //注册成功转到登录界面
        if(xyService.addXy(xy)){
            System.out.println("注册新校友"+xy.getXid());
            return "index";
        }
        //重新注册
        else return "xyregister";
    }
}
