package xyl.cct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.pojo.Ly;
import xyl.cct.pojo.Xy;
import xyl.cct.service.LyService;
import xyl.cct.service.XyService;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class LyController {
    @Resource(name = "lyService")
    private LyService lyService;
    @Resource(name = "xyService")
    private XyService xyService;

    /*
    vuetest
     *管理员从数据库中拉取所有留言未审核的留言
     */
    @ResponseBody
    @RequestMapping(value = "/glyGetAllLy")
    public List GlygetAllLy(){
        //有个问题，怎样才能把留言人姓名传过去
        //格式化json吗？？？
        System.out.print("获取未通过审核留言");
        List<Ly> ly=lyService.getAllLy0();
        return ly;
    }

    /*
    vuetest
     *校友从数据库中拉取能够查看的所有留言（审核过的）
     */
    @ResponseBody
    @RequestMapping(value = "/xyGetAllLy")
    public List XygetAllLy(){
        //有个问题，怎样才能把留言人姓名传过去
        //格式化json吗？？？
        System.out.print("获取审核通过留言");
        List<Ly> ly=lyService.getAllLy();
        return ly;
    }

    /*
   vuetest
    *校友从数据库中拉取能够查看自己的所有留言
    */
    @ResponseBody
    @RequestMapping(value = "/xyGetSelfLy")
    public List XygetSelfLy(@RequestParam(value = "name",required = false)String nowxy){
        System.out.print(nowxy+"的留言");
        Xy xy=xyService.getXyByName(nowxy);
       List<Ly> ly=null;
       ly=lyService.getSelfLy(xy);
       //if(ly.size()==0)System.out.print("empty");
        return ly;
    }

    /*
    vuetest留言
     */
    @ResponseBody
    @RequestMapping(value = "/addLy.do")
    public Boolean addLy(
            @RequestParam(value = "lyxyname",required = false)String name,
            @RequestParam(value = "info",required = false)String info
    ){
        boolean ok=false;
        Ly ly=new Ly();
        try {
            String iinfo = URLDecoder.decode(info, "utf-8");
            Xy xy=xyService.getXyByName(name);
            if(!xy.getName().equals(null)){
                System.out.println(xy.getName()+"添加留言"+iinfo);
                Timestamp time=new Timestamp(System.currentTimeMillis());
                ly.setXyByLyxid(xy);
                ly.setState(0);
                ly.setInfo(iinfo);
                ly.setLydate(time);
                ok=lyService.addLy(ly);
            }
        }
        catch (Exception e){
            System.out.print("编码error");
            ok=false;
        }
        return ok;
    }

    /*
    删除留言信息
     */
    @ResponseBody
    @RequestMapping(value = "/delete.do")
    public boolean deleteLy(@RequestParam(value = "lid",required = false) int id){
        System.out.println("删除留言"+id);
        boolean ok;
        ok=lyService.deleteLy(id);
        return ok;
    }

    /*
    通过未审核留言
     */
    @ResponseBody
    @RequestMapping(value = "/passLy.do")
    public boolean delete(@RequestParam(value = "lid",required = false) int id){
        System.out.println("通过留言"+id);
        boolean ok;
        ok=lyService.updateState(id);
        return ok;
    }

    /*
    * 设置精选留言
     */
    @ResponseBody
    @RequestMapping(value = "/asBest.do")
    public boolean asBest(int lid) {
        if(lyService.setAsBest(lid)) {
            return true;
        } else {
            return false;
        }
    }

}
