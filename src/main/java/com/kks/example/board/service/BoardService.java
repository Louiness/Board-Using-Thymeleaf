package com.kks.example.board.service;

import com.kks.example.board.dto.BoardRequestDTO;
import com.kks.example.board.dto.BoardResponseDTO;
import com.kks.example.board.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {

    Page<BoardEntity> getBoardAllList(Pageable pageable);

    Long savePost(BoardRequestDTO boardRequestDTO);
}
