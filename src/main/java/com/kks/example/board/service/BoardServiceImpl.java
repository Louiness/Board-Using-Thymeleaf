package com.kks.example.board.service;

import com.kks.example.board.dto.BoardRequestDTO;
import com.kks.example.board.entity.BoardEntity;
import com.kks.example.board.entity.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Page<BoardEntity> getBoardAllList(Pageable pageable) {
        Page<BoardEntity> boardEntityList = boardRepository.findAll(pageable);

        return boardEntityList;
    }

    @Transactional
    @Override
    public Long savePost(BoardRequestDTO boardRequestDTO) {

        boardRequestDTO.setPostingDate(LocalDate.now());
        boardRequestDTO.setViews(0L);

        return boardRepository.save(boardRequestDTO.toEntity()).getIdx();
    }


}
