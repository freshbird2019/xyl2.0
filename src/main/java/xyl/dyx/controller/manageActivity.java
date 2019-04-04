package xyl.dyx.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xyl.dyx.POJO.ActivityEntity;
import xyl.dyx.service.activityEntityService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class manageActivity {
    @Resource(name = "activityEntityService")
    private activityEntityService acService;

    /*
     * 获取所有活动信息
     */
    @ResponseBody
    @RequestMapping(value = "/activityPg")
    public String activityPg() {

        List<ActivityEntity> acList = acService.getAllActivities();

        Gson gson = new Gson();

        return gson.toJson(acList);

    }
    /*
     * 删除活动
     */
    @ResponseBody
    @RequestMapping(value = "/deleteAc.do")
    public boolean delete(@RequestParam int id) {


        if(acService.deleteActivityEntity(id)) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * 添加活动
     */
    @ResponseBody
    @RequestMapping(value = "/addAc.do")
    public boolean add(@RequestParam String name, @RequestParam String time,
                       @RequestParam String location, @RequestParam int num,
                       @RequestParam String description) {

        ActivityEntity ac = new ActivityEntity();
        ac.setDescription(description);
        ac.setLocation(location);
        ac.setName(name);
        ac.setTime(time);
        ac.setNum(num);

        if(acService.addActivityEntity(ac)) {
            return true;
        } else {
            return false;
        }
    }

}
