package xyl.cct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.pojo.Clazz;
import xyl.cct.pojo.Xy;
import xyl.cct.service.ClazzService;
import xyl.cct.service.XyService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class XyController {
    @Resource(name = "xyService")
    private XyService xyService;
    @Resource(name="ClazzService")
    private ClazzService clazzService;

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
   获取未加入班级的校友信息0
    */
    @ResponseBody
    @RequestMapping(value = "/getAllXy0", method = RequestMethod.GET)
    public List<Xy> getAllXy0() {
        System.out.print("获取未加入班级的校友信息");
        List<Xy> list=xyService.getAllXy0();
        return list;
    }

    /*
  获取申请状态的校友信息1
   */
    @ResponseBody
    @RequestMapping(value = "/getAllXy1", method = RequestMethod.GET)
    public List<Xy> getAllXy1() {
        System.out.print("获取申请状态的校友信息");
        List<Xy> list=xyService.getAllXy1();
        return list;
    }


    /*
   获取加入过班级的校友信息2
    */
    @ResponseBody
    @RequestMapping(value = "/getAllXy2", method = RequestMethod.GET)
    public List<Xy> getAllXy2() {
        System.out.print("获取加入过班级的校友信息");
        List<Xy> list=xyService.getAllXy2();
        return list;
    }

    /*
    根据xyname返回校友信息
     */
    @ResponseBody
    @RequestMapping(value = "/getXyByname")
    public Xy getXyByName(@RequestParam(value = "xyname",required = false)String name){
        System.out.print("获取校友信息"+name);
        Xy xy=xyService.getXyByName(name);
        return xy;
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
    校友申请某班级
     */
    @ResponseBody
    @RequestMapping(value = "/applyClass")
    public boolean applyClass(
            @RequestParam(value = "classid",required = false)int id,
            @RequestParam(value = "xyname",required = false)String name){
        boolean ok=false;
        System.out.print(name+"申请加入班级"+id);
        Xy xy=xyService.getXyByName(name);
        xy.setState(1);
        Clazz clazz=clazzService.getClassById(id);
        xy.setClazzByClassid(clazz);
        ok=xyService.updateXyEntity(xy);
        System.out.print(xy.getClazzByClassid().getName());
        return ok;
    }

    /*
    获取校友所在的班级名称
     */
    @ResponseBody
    @RequestMapping(value = "getClaidByXyname")
    public int getClaidByXid(
            @RequestParam(value = "xyname",required = false)String name){
        Xy xy=xyService.getXyByName(name);
        int claid;
        claid=xy.getClazzByClassid().getCid();//????获取是空的！我日！
        return claid;
    }

    /*
    修改校友信息，
     */
    @ResponseBody
    @RequestMapping("/updateNowin.do")
    public Boolean updateNowin(@RequestBody Xy xy){
        boolean ok=false;
        System.out.println("修改校友信息"+xy.getXid()+xy.getName());
        ok=xyService.updateXyEntity(xy);
        return ok;
    }

    /*
     * 将该学生踢出班级
     */
    @ResponseBody
    @RequestMapping("/apply.do")
    public boolean deleteClaMember(int xid, int state) {
        if(xyService.xyOutCla(xid, state)) {
            return true;
        } else {
            return false;
        }
    }
}
