package com.kks.example.board.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "BOARD")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idx;

    @Column(name = "board_title", length = 100, nullable = false)
    private String boardTitle;

    @Column(name = "board_content", columnDefinition = "TEXT", nullable = false)
    private String boardContent;

    @Column(name = "user_name", length = 15, nullable = false)
    private String userName;

    @Column(name = "posting_date")
    private LocalDate postingDate;

    @Column
    private Long views;

    @Builder
    public BoardEntity(String boardTitle, String boardContent, String userName, LocalDate postingDate, Long views) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.userName = userName;
        this.postingDate = postingDate;
        this.views = views;
    }
}