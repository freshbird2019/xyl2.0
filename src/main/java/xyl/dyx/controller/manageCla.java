package xyl.dyx.controller;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.dao.ClazzDao;
import xyl.cct.pojo.Clazz;
import xyl.cct.pojo.Xy;
import xyl.cct.service.ClazzService;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.List;
@Controller
public class manageCla {

    @Resource(name = "ClazzService")
    ClazzService claSer;

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

        List<Xy> xyList = claSer.getAllXy(id);

        System.out.println(xyList.size());

        Gson gson = new Gson();

        return gson.toJson(xyList);
    }

}
