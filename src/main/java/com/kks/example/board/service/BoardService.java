package com.kks.example.board.service;

import com.kks.example.board.dto.BoardRequestDTO;
import com.kks.example.board.dto.BoardResponseDTO;

import java.util.List;

public interface BoardService {

    List<BoardResponseDTO> getBoardAllList();

    Long savePost(BoardRequestDTO boardRequestDTO);
}
