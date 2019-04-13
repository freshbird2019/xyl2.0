package xyl.cct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyl.cct.pojo.FindNotice;
import xyl.cct.service.FindNoticeService;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class FindNoticeController {
    @Resource(name = "findService")
    private FindNoticeService findNoticeService;

    /*
   获取寻人启事消息
   cid前端传来的班级号
   寻找本班寻人启事
    */
    @ResponseBody
    @RequestMapping(value = "/getAllFindNotice", method = RequestMethod.GET)
    public List<FindNotice> getAllFindNotice(@RequestParam int cid) {
        System.out.print("获取寻人启事");
        List<FindNotice> list=findNoticeService.getAll(cid);
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/addFindNotice")
    public boolean addFindNotice(@RequestBody FindNotice findNotice) {
        Timestamp time=new Timestamp(System.currentTimeMillis());
        findNotice.setFtime(time);
        boolean ok=findNoticeService.saveOneFind(findNotice);
        return ok;
    }

    @ResponseBody
    @RequestMapping(value = "/deleteFindNotice")
    public boolean deleteFindNotice(@RequestParam int id) {
        boolean ok =findNoticeService.deleteOneFind(id);
        return ok;
    }
}
