package xyl.cct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.pojo.Xy;
import xyl.cct.service.XyService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class XyController {
    @Resource(name = "xyService")
    private XyService xyService;

    /*
    vuetest校友登录
     */
    @RequestMapping("/llogin")
    @ResponseBody
    public int llogin(
            @RequestParam(value = "name",required = false)String name,
            @RequestParam(value = "pw",required = false)String pw,
            Model model){
        Xy xy=new Xy();
        xy.setName(name);
        xy.setPw(pw);
        System.out.println(name+"+"+pw);
        int nowid=xyService.ifCorrect(xy);
        System.out.println(nowid);
        if(nowid>0) {//存在则进入主界面
            xy.setXid(nowid);
            model.addAttribute(
                    "nowinxy",xy);
        } else {
            model.addAttribute("error","登录失败");
        }
        return nowid;
    }

    /*
    校友注册
     */
    @ResponseBody
    @RequestMapping(value = "/register.do")
    public boolean Xyregister(@RequestBody Xy xy){
        System.out.println("注册新校友"+xy.getName());
        boolean ok;
        xy.setState(0);
        //注册成功转到登录界面
        ok=xyService.addXy(xy);
        System.out.println("注册新校友"+xy.getXid());
        return ok;
    }

    /*
   获取加入过班级的校友信息0
    */
    @ResponseBody
    @RequestMapping(value = "/getAllXy0", method = RequestMethod.GET)
    public List<Xy> getAllXy0() {
        System.out.print("获取加入过班级的校友信息");
        List<Xy> list=xyService.getAllXy0();
        return list;
    }

    /*
   获取未加入班级的校友信息1
    */
    @ResponseBody
    @RequestMapping(value = "/getAllXy1", method = RequestMethod.GET)
    public List<Xy> getAllXy1() {
        System.out.print("获取未加入班级的校友信息");
        List<Xy> list=xyService.getAllXy1();
        return list;
    }

    /*
  获取申请状态的校友信息2
   */
    @ResponseBody
    @RequestMapping(value = "/getAllXy2", method = RequestMethod.GET)
    public List<Xy> getAllXy2() {
        System.out.print("获取申请状态的校友信息");
        List<Xy> list=xyService.getAllXy2();
        return list;
    }

    /*
    获取与当前校友同班的校友信息
     */
    @ResponseBody
   @RequestMapping(value = "/getXyByClassId" ,method=RequestMethod.GET)
    public List<Xy> getXyByClassId(@RequestParam(value = "classid",required = false)int id){
        System.out.print("获取班级号为"+id+"的校友信息");
        List<Xy> list=xyService.getXyByClassId(id);
        return list;
    }

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
}
