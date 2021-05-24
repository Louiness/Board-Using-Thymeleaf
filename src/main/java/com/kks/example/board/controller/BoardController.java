package com.kks.example.board.controller;

import com.kks.example.board.dto.BoardRequestDTO;
import com.kks.example.board.dto.BoardResponseDTO;
import com.kks.example.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/")
    public ModelAndView view() {

        ModelAndView mav = new ModelAndView();

        List<BoardResponseDTO> boardResponseDTOList = boardService.getBoardAllList();

        mav.addObject("boardList", boardResponseDTOList);
        mav.setViewName("board");

        return mav;
    }

    @GetMapping("/write")
    public ModelAndView write() {

        ModelAndView mav = new ModelAndView();

        mav.addObject("boardRequestDTO", new BoardRequestDTO());
        mav.setViewName("write");

        return mav;
    }

    @PostMapping("/write/save")
    public ModelAndView save(BoardRequestDTO boardRequestDTO) {

        ModelAndView mav = new ModelAndView();

        boardService.savePost(boardRequestDTO);

        mav.setViewName("redirect:/");

        return mav;
    }
}
