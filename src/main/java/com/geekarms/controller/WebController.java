package com.geekarms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kaywer on 2016/12/28.
 */
@Controller
public class WebController {
    @RequestMapping("/toLoginPage")
    public String login(){
        return "login";
    }

    @RequestMapping("/success")
    public String success(){
        return "success";
    }

    @RequestMapping("/error")
    public String error(){
        return "error";
    }

}
