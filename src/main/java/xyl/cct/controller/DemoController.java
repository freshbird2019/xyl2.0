
package xyl.cct.controller;



import xyl.cct.pojo.LyEntity;
import xyl.cct.pojo.XyEntity;
import xyl.cct.service.LyEntityService;
import xyl.cct.service.XyEntityService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller

public class DemoController {


    @Resource(name = "lyEntityService")
    private LyEntityService lyEntityService;
    @Resource(name = "xyEntityService")
    private XyEntityService xyEntityService;

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
    @RequestMapping(value = "/getAllXyEntity", method = RequestMethod.GET)
    public ModelAndView getAllXy() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("xys",xyEntityService.getAllXyEntity());
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
    public String XyaddLy(LyEntity l){
        String s=l.getLyInfo();System.out.println("添加留言"+s);
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=df.format(new Date());
        l.setLyLyr("cct");
        l.setLyDate(time);
        int x=lyEntityService.getMaxId();
        l.setLyId(x+1);
        System.out.println(l.getLyId());
        lyEntityService.addLyEntity(l);
        return "lysuccess";
    }
    /*
    删除留言信息
     */
    @RequestMapping(value = "/delete.do")
    public String deleteLy(int id){
        System.out.println(id);
        lyEntityService.deleteLyEntity(id);
        return "redirect:/getAllLyEntity";
    }

    /*
    修改校友信息,
    将要修改的校友信息传过来
    跳转到updatexy界面修改
     */
    @RequestMapping(value = "/updateXyEntity.do")
    public String updateXy(int id,Model model){
        System.out.println(id);
        XyEntity x=xyEntityService.getXyEntityById(id);
       // System.out.println(x.getId());
        model.addAttribute("xy",x);
        return "updatexy";
    }

    /*
    修改校友信息，
    成功后回到主界面
     */
    @RequestMapping("/update.do")
    public String update(XyEntity x){
        System.out.println("修改校友信息"+x.getXyUsername());
        xyEntityService.updateXyEntity(x);
        return "redirect:/getAllXyEntity";
    }

    /*
    *从数据库中拉取所有留言
     */
    @RequestMapping(value = "/getAllLyEntity")
    public ModelAndView getAllLyEntity(){
        ModelAndView mv=new ModelAndView();
        mv.addObject("lys",lyEntityService.getAllLyEntity());
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
    @RequestMapping(value = "/register.do")
    public String Xyregister(XyEntity xy){
        System.out.println("注册新校友"+xy.getXyUsername());
        int index=xyEntityService.getMaxId()+1;
        xy.setXyId(index);
        //注册成功转到登录界面
        if(xyEntityService.addXyEntity(xy)){
            System.out.println("注册新校友"+xy.getXyId());
            return "index";
        }
        //重新注册
        else return "xyregister";
    }
}

