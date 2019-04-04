package xyl.dyx.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xyl.cct.pojo.Ly;
import xyl.cct.service.LyService;
import xyl.dyx.service.Exclusion;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class manageLy {


    @Resource(name = "lyService")
    private LyService lyService;

    /*
     * 管理留言信息
     */
    @ResponseBody
    @RequestMapping(value = "/glLy")
    public String glLy() {

        List<Ly> lyList = lyService.getAllLy();

        List<String> gl = new ArrayList<>();
        gl.add("xyByLyxid");


        Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new Exclusion(gl)).create();

        return gson.toJson(lyList);

    }


    /*
    * 删除留言
     */
    @ResponseBody
    @RequestMapping(value = "/deleteLy.do")
    public boolean deleteLy(@RequestParam int id) {

        if(lyService.deleteLy(id)) {
            return true;
        } else {
            return false;
        }

    }

    @ResponseBody
    @RequestMapping("/admitLy.do")
    public boolean admitLy(int id) {

        if(lyService.updateState(id)) {
            return true;
        }else {
            return  false;
        }

    }
}

