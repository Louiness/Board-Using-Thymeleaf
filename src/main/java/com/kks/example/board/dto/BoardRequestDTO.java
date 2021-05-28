package com.kks.example.board.dto;

import com.kks.example.board.entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
