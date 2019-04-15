package xyl.cct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyl.cct.pojo.FindNotice;
import xyl.cct.pojo.Xy;
import xyl.cct.service.FindNoticeService;
import xyl.cct.service.XyService;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class FindNoticeController {
    @Resource(name = "findService")
    private FindNoticeService findNoticeService;
    @Resource(name = "xyService")
    private XyService xyService;

    /*
   获取寻人启事消息
   cid前端传来的班级号
   寻找本班寻人启事
    */
    @ResponseBody
    @RequestMapping(value = "/getAllFindNotice", method = RequestMethod.GET)
    public List<FindNotice> getAllFindNotice(@RequestParam int cid) {
        System.out.print("获取寻人启事"+cid);
        List<FindNotice> list=findNoticeService.getAll(cid);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/addFindNotice")
    public boolean addFindNotice(@RequestParam(value = "xyname",required = false) String xyname,
                                 @RequestParam(value = "state",required = false) int state,
                                 @RequestParam(value = "title",required = false) String title,
                                 @RequestParam(value = "description",required = false) String description) {
        boolean ok=false;
        FindNotice findNotice = new FindNotice();
        Timestamp time=new Timestamp(System.currentTimeMillis());
        Xy xy=xyService.getXyByName(xyname);
        try {
            String t = URLDecoder.decode(title, "utf-8");
            String d = URLDecoder.decode(description, "utf-8");
            findNotice.setFtime(time);
            findNotice.setDescription(d);
            findNotice.setFtitle(t);
            findNotice.setShowstate(state);
        }
        catch (Exception e){
            System.out.print("编码error");
            ok=false;
        }
        findNotice.setXyByFid(xy);System.out.println("加入一则寻人启事");
        ok=findNoticeService.saveOneFind(findNotice);
        return ok;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteFindNotice")
    public boolean deleteFindNotice(@RequestParam int id) {
        boolean ok =findNoticeService.deleteOneFind(id);
        return ok;
    }
}
