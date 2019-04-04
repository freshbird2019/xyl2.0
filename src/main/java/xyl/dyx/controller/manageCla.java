package xyl.dyx.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.service.XyService;
import xyl.dyx.service.Exclusion;
import xyl.cct.dao.ClazzDao;
import xyl.cct.pojo.Clazz;
import xyl.cct.pojo.Xy;
import xyl.cct.service.ClazzService;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;
@Controller
public class manageCla {

    @Resource(name = "ClazzService")
    ClazzService claSer;

    @Resource(name = "xyService")
    XyService xySer;

    // 管理班级界面
    @ResponseBody
    @RequestMapping("/glClass")
    public String glCla() {

        List<Clazz> clazzList = claSer.getAllCla();

        Gson gson = new Gson();

        return gson.toJson(clazzList);
    }

    // 添加班级
    @ResponseBody
    @RequestMapping("/addClass")
    public boolean allClass(@RequestParam String name,
                           @RequestParam String year, @RequestParam String major,
                            @RequestParam String college) {

        Clazz cla = new Clazz();
        cla.setCollege(college);
        cla.setMajor(major);
        cla.setName(name);
        cla.setYear(year);

        if(claSer.addCla(cla)) {

            return true;

        } else {

            return false;

        }


    }

    // 查看班级成员信息，id是查看班级的id
    @ResponseBody
    @RequestMapping("/displayMember")
    public String displayMember(@RequestParam int id) {

        List<Xy> xy = claSer.getAllXy(id);

        //此为要过滤掉的属性数组
        List<String> gl = new ArrayList<>();
        gl.add("liesByXid");

        //创建临时实例,并编写过滤规则
        Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new Exclusion(gl) ).create();
        String json = gson.toJson(xy);

        return json;
    }

    // 更新校友状态，通过审核
    @ResponseBody
    @RequestMapping("/passXy.do")
    public boolean passXy(@RequestParam int id) {

        Xy xy = xySer.getXyById(id);

        xy.setState(1);

        if(xySer.updateXyEntity(xy)) {
            return true;
        } else {
            return false;
        }
    }

    // 更新班级信息
    @ResponseBody
    @RequestMapping("/updateCla.do")
    public boolean updateXy(@RequestParam String name,
                           @RequestParam String year, @RequestParam String major,
                           @RequestParam String college) {

        Clazz cla = new Clazz();
        cla.setCollege(college);
        cla.setMajor(major);
        cla.setName(name);
        cla.setYear(year);

        if(claSer.update(cla)) {
            return true;
        } else {
            return false;
        }

    }

}
