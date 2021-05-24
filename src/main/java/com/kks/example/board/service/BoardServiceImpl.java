package com.kks.example.board.service;

import com.kks.example.board.dto.BoardRequestDTO;
import com.kks.example.board.dto.BoardResponseDTO;
import com.kks.example.board.entity.BoardEntity;
import com.kks.example.board.entity.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public List<BoardResponseDTO> getBoardAllList() {
        List<BoardResponseDTO> boardResponseDTOList = new ArrayList<>();

        for (BoardEntity boardEntity : boardRepository.findAll()) {

            if(Optional.ofNullable(boardEntity) != null){
                boardResponseDTOList.add(new BoardResponseDTO(boardEntity));
            }
        }
        return boardResponseDTOList;
    }

    @Transactional
    @Override
    public Long savePost(BoardRequestDTO boardRequestDTO) {

        boardRequestDTO.setPostingDate(LocalDate.now());
        boardRequestDTO.setViews(0L);

        return boardRepository.save(boardRequestDTO.toEntity()).getIdx();
    }


}
