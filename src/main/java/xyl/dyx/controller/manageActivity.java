package xyl.dyx.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.pojo.Xy;
import xyl.dyx.POJO.ActivityEntity;
import xyl.dyx.service.Exclusion;
import xyl.dyx.service.activityEntityService;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    /*
    * 获取某活动所有报名人信息
     */
    @ResponseBody
    @RequestMapping("/getAcXy")
    public String getAcMembers(@RequestParam int num) {
        List<String> gl = new ArrayList<>();
        gl.add("liesByXid");

        Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new Exclusion(gl)).create();

        //System.out.println("???");
        List<Xy> xy = acService.getAcXy(num);

        // 若无人报名则返回空
        if (xy == null) {
            return null;
        } else {
            return gson.toJson(xy);
        }
    }

    /*
    * 获取某学生报名的所有活动
     */
    @ResponseBody
    @RequestMapping("/getXyAc")
    public String getXyActivity(@RequestParam int num) {

        Gson gson = new Gson();

        List<ActivityEntity> ac = acService.getXyAcSer(num);

        if (ac == null) {
            return null;
        } else {
            return gson.toJson(ac);
        }
    }

    /*
    * 报名参加某活动
     */
    @ResponseBody
    @RequestMapping("/joinAc")
    public boolean joinAc(@RequestParam int aid, @RequestParam int xid) {

        if(acService.joinAc(aid, xid)) {
            return true;
        } else {
            return false;
        }
    }


}
