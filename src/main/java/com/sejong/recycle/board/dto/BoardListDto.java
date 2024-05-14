package com.sejong.recycle.board.dto;


import com.sejong.recycle.board.Board;
import com.sejong.recycle.board.BoardType;
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
    private BoardType boardType;


    public BoardListDto(Board board) {
        this.boardId = board.getId();
        this.title = board.getTitle();
        this.createdAt = board.getCreatedAt();
        this.nickname = board.getNickname();
        this.boardType = board.getBoardType();
    }
}
