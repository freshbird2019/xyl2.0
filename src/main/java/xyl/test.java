package xyl;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.mapping.Join;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyl.cct.pojo.Clazz;
import xyl.cct.pojo.Xy;
import xyl.dyx.POJO.ActivityEntity;
import xyl.dyx.POJO.JoinAcEntity;
import xyl.dyx.controller.hibernateUtil;
import xyl.dyx.service.Exclusion;
import xyl.dyx.service.activityEntityService;

import javax.annotation.Resource;
import javax.management.Query;
import javax.sql.rowset.Joinable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class test {
    @Resource( name = "activityEntityService")
    activityEntityService ser = new activityEntityService();

    @ResponseBody
    @RequestMapping("/test")
    public String test(String name,String year,  String major, String college) {

        System.out.println(name);

        return "hellp";
    }


}
