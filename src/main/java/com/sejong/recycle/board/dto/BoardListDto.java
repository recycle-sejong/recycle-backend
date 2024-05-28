package com.sejong.recycle.board.dto;


import com.sejong.recycle.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardListDto {

    private Long boardId;
    private String title;
    private LocalDateTime createdAt;
    private String nickname;
    private String content;



    public BoardListDto(Board board) {
        this.boardId = board.getId();
        this.title = board.getTitle();
        this.createdAt = board.getCreatedAt();
        this.nickname = board.getNickname();
        this.content = board.getContent();
    }
}
