package com.kks.example.board.service;

import com.kks.example.board.dto.BoardResponseDTO;

import java.util.List;

public interface BoardService {

    public List<BoardResponseDTO> getBoardAllList();
}
