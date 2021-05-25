package com.kks.example.user.controller;

import com.kks.example.user.service.UserService;
import com.kks.example.user.vo.UserRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping(value="/signin")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView signIn_view() {

        ModelAndView mav = new ModelAndView();

        mav.addObject("userVO", new UserRequestVO());
        mav.setViewName("signin");

        return mav;
    }

    @GetMapping("/signup")
    public ModelAndView signUp_view() {

        ModelAndView mav = new ModelAndView();

        mav.addObject("userVO", new UserRequestVO());
        mav.setViewName("signup");

        return mav;
    }

    @PostMapping("/signup/save")
    public ModelAndView signUp_save(UserRequestVO userRequestVO) {

        ModelAndView mav = new ModelAndView();

        userService.save(userRequestVO);

        mav.setViewName("redirect:/signin");

        return mav;
    }
}
