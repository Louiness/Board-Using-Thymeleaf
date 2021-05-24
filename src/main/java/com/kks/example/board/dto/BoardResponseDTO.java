package com.kks.example.board.dto;

import com.kks.example.board.entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class BoardResponseDTO {

    private long idx;
    private String boardTitle;
    private String boardContent;
    private String userName;
    private LocalDate postingDate;
    private Long views;

    public BoardResponseDTO(BoardEntity entity) {
        this.idx = entity.getIdx();
        this.boardTitle = entity.getBoardTitle();
        this.boardContent = entity.getBoardContent();
        this.userName = entity.getUserName();
        this.postingDate = entity.getPostingDate();
        this.views = entity.getViews();
    }
}
