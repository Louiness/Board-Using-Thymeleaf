package com.kks.example.board.controller;

import com.kks.example.board.dto.BoardResponseDTO;
import com.kks.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/")
    public ModelAndView init() {
        boardService.getBoardAllList().forEach(x -> x.getBoardContent());

        ModelAndView mav = new ModelAndView();
        mav.addObject("comment", "Hello Thymeleaf!");
        mav.setViewName("index");

        return mav;
    }
}
