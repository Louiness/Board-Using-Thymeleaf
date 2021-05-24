package com.kks.example.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
public class BoardRequestDTO {

    private Long index;
    private String boardTitle;
    private String boardContent;
    private String userName;
    private LocalDate date;
    private Long views;

    public BoardRequestDTO() { }

}
