
package xyl.cct.controller;



import xyl.cct.pojo.Xy;
import xyl.cct.pojo.Ly;
import xyl.cct.service.LyService;
import xyl.cct.service.XyService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.sql.Timestamp;


@Controller

public class DemoController {


    @Resource(name = "lyService")
    private LyService lyService;
    @Resource(name = "xyService")
    private XyService xyService;

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "hello");
        mv.setViewName("index");
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
    跳转到添加留言页面
     */
    @RequestMapping(value = "/addLy.do")
    public String addLy(){
        /*lyService.addLy(l);*/
        return "addly";
    }

    /*
    添加留言
    发送留言给管理员审核，跳转到成功页面
     */
    @RequestMapping(value = "/XyaddLy.do",method = RequestMethod.POST)
    public String XyaddLy(Ly l){
        String s=l.getInfo();System.out.println("添加留言"+s);
        //SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp time=new Timestamp(System.currentTimeMillis());
        //怎么设置留言人学号
        l.setLydate(time);
        l.setState(0);
        System.out.println(l.getLid());
        lyService.addLy(l);
        return "lysuccess";
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
    修改校友信息,
    将要修改的校友信息传过来
    跳转到updatexy界面修改
     */
    @RequestMapping(value = "/updateXy.do")
    public String updateXy(int id,Model model){
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
    *从数据库中拉取所有留言
     */
    @RequestMapping(value = "/getAllLy")
    public ModelAndView getAllLyEntity(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("lys",lyService.getAllLy());
        mv.setViewName("lydisplay");
        return mv;
    }

    /*
    转到校友注册界面
     */
    @RequestMapping(value = "/xyRegister")
    public String register(){
        return "xyregister";
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

