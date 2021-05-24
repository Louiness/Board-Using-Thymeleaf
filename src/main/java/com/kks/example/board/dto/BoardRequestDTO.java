package com.kks.example.board.dto;

import com.kks.example.board.entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class BoardRequestDTO {

    private String boardTitle;
    private String boardContent;
    private String userName;
    private LocalDate postingDate;
    private Long views;

    @Builder
    public BoardRequestDTO(String boardTitle, String boardContent, String userName, LocalDate postingDate, Long views) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.userName = userName;
        this.postingDate = postingDate;
        this.views = views;
    }

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .userName(userName)
                .postingDate(postingDate)
                .views(views)
                .build();
    }

}
