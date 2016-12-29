package com.geekarms.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kaywer on 2016/12/28.
 */
@Controller
public class CheckUserAuthorityController {

    @PreAuthorize("hasAuthority('Foo')")
    @RequestMapping("/checkHasFooAuthority")
    public ModelAndView checkHasFooAuthority(ModelAndView view){
        view.addObject("msg", "能够进入本方法，即用户拥有 \"Foo\" authority");
        view.setViewName("success");
        return view;
    }
}
