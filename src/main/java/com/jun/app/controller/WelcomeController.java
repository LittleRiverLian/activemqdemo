package com.jun.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zz on 2017/8/16.
 */
@Controller
public class WelcomeController {

    @RequestMapping(value="/welcome",method= RequestMethod.GET)
    protected ModelAndView welcome(){
        System.out.println("------------welcome");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        return mv;
    }
}
