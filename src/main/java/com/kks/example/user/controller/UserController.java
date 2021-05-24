package com.kks.example.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @PostMapping("/signin")
    public ModelAndView signIn() {

        ModelAndView mav = new ModelAndView();

        mav.setViewName("redirect:/");

        return mav;
    }

    @PostMapping("/signup")
    public ModelAndView signUp() {

        ModelAndView mav = new ModelAndView();

        mav.setViewName("redirect:/signin");

        return mav;
    }
}
