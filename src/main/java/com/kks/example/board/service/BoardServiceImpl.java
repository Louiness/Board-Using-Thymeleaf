package com.kks.example.board.service;

import com.kks.example.board.dto.BoardResponseDTO;
import com.kks.example.board.entity.BoardEntity;
import com.kks.example.board.entity.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<BoardResponseDTO> getBoardAllList() {
        List<BoardResponseDTO> boardResponseDTOList = new ArrayList<>();

        for (BoardEntity boardEntity : boardRepository.findAll()) {
            BoardResponseDTO boardResponseDTO = BoardResponseDTO.builder()
                    .boardTitle(boardEntity.getBoardTitle())
                    .boardContent(boardEntity.getBoardContent())
                    .userName(boardEntity.getUserName())
                    .date(boardEntity.getPostingDate())
                    .views(boardEntity.getViews())
                    .build();

            boardResponseDTOList.add(boardResponseDTO);
        }
        return boardResponseDTOList;
    }
}
