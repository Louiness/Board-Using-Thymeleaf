package com.kks.example.board.controller;

import com.kks.example.board.dto.BoardRequestDTO;
import com.kks.example.board.entity.BoardEntity;
import com.kks.example.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Slf4j
@Controller
@RequestMapping(value="/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("")
    public ModelAndView board_view(@PageableDefault(size = 10, sort = "idx", direction = Sort.Direction.DESC) Pageable pageable) {

        ModelAndView mav = new ModelAndView();

        Page<BoardEntity> boardList = boardService.getBoardAllList(pageable);
        int startPage = Math.max(1, boardList.getPageable().getPageNumber() - 1);
        int endPage = Math.min(boardList.getTotalPages(), boardList.getPageable().getPageNumber() + 3);

        mav.addObject("boardList", boardList);
        mav.addObject("startPage", startPage);
        mav.addObject("endPage", endPage);

        mav.setViewName("board/board");

        return mav;
    }

    @GetMapping("/write")
    public ModelAndView board_write() {

        ModelAndView mav = new ModelAndView();

        mav.addObject("boardRequestDTO", new BoardRequestDTO());
        mav.setViewName("board/write");

        return mav;
    }

    @PostMapping("/write/save")
    public ModelAndView board_write_save(BoardRequestDTO boardRequestDTO) {

        ModelAndView mav = new ModelAndView();

        boardRequestDTO.setPostingDate(LocalDate.now());

        boardService.savePost(boardRequestDTO);

        mav.setViewName("redirect:/");

        return mav;
    }
}
