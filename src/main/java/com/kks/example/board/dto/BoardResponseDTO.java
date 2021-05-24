package com.kks.example.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class BoardResponseDTO {

    private String boardTitle;
    private String boardContent;
    private String userName;
    private LocalDate date;
    private Long views;

    @Builder
    public BoardResponseDTO(String boardTitle, String boardContent, String userName, LocalDate date, Long views) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.userName = userName;
        this.date = date;
        this.views = views;
    }
}
