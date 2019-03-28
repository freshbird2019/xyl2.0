package xyl.cct.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JumpController {
    /*
    转到校友注册界面
     */
    @RequestMapping(value = "/xyRegister")
    public String register(){
        return "xyregister";
    }

    /*
    转到校友登录界面
     */
    @RequestMapping(value = "/xyLogin")
    public String xyLogin(){ return "xylogin";}
}
