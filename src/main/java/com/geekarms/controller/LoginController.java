package com.geekarms.controller;

import com.geekarms.entity.User;
import com.geekarms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 * Created by kaywer on 2016/12/28.
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/doLogin")
    public String login(@RequestParam String login, @RequestParam String password, RedirectAttributes attr) {
        try {
            User user = loginService.login(login, password);
            String msg;
            String url;
            if (user == null){
                msg = "账号密码出错";
                url = "/error";
            }else {
                msg = "登录成功";
                url = "/success";
            }
            attr.addFlashAttribute("msg", msg);
            return "redirect:" + url;
        }catch (Exception e){
            e.printStackTrace();
            attr.addFlashAttribute("msg", e.getMessage());
            return "redirect:" + "/error";
        }

    }
}
