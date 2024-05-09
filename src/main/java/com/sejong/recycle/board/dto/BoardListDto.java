package com.sejong.recycle.board.dto;


import com.sejong.recycle.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardListDto {

    private Long id;
    private String title;
    private LocalDateTime createdAt;


    public BoardListDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.createdAt = board.getCreatedAt();
    }
}
