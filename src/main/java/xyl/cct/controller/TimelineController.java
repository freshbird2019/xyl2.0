package xyl.cct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyl.cct.pojo.Timeline;
import xyl.cct.pojo.Xy;
import xyl.cct.service.TimelineService;
import xyl.cct.service.XyService;

import javax.annotation.Resource;
import java.net.URLDecoder;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class TimelineController {
    @Resource(name = "xyService")
    private XyService xyService;
    @Resource(name = "timeService")
    private TimelineService timelineService;

    @ResponseBody
    @RequestMapping(value = "/addTimeline")
    public boolean addTimeline(@RequestParam(value = "xyname",required = false) String xyname,
                                 @RequestParam(value = "type",required = false) int type,
                                 @RequestParam(value = "description",required = false) String description) {
        boolean ok=false;
        Timeline timeline=new Timeline();
        Timestamp time=new Timestamp(System.currentTimeMillis());
        Xy xy=xyService.getXyByName(xyname);
        try {
            System.out.println(xyname+type+description);
            String t = URLDecoder.decode(description, "utf-8");
            timeline.setDescription(t);
            timeline.setTtime(time);
            timeline.setType(type);
            timeline.setXyByTid(xy);
        }
        catch (Exception e){
            System.out.print("编码error");
            ok=false;
        }
        timeline.setXyByTid(xy);System.out.println("加入时间线");
        ok=timelineService.saveOneFind(timeline);
        return ok;
    }

    @ResponseBody
    @RequestMapping(value = "/getTimeline")
    public List<Timeline> getTimeline(@RequestParam(value = "xyname",required = false)String xyname) {
        Xy xy=xyService.getXyByName(xyname);
        int id=xy.getXid();
        System.out.print("获取时间线"+id);
        List<Timeline> list=timelineService.getAll(id);
        return list;
    }
}
