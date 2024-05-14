package com.sejong.recycle.board.dto;


import com.sejong.recycle.board.Board;
import com.sejong.recycle.board.BoardType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardResDto {
    private Long boardId;

    private String title;

    private String content;

    private String image;

    private String nickname;
    private BoardType boardType;

    private Double latitude; //위도
    private Double longitude; //경도
    private LocalDateTime createdAt;

    public BoardResDto(Board board) {
        this.boardId = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.image = board.getImage();
        this.nickname = board.getNickname();
        this.boardType = board.getBoardType();
        this.latitude = board.getLatitude();
        this.longitude = board.getLongitude();
        this.createdAt = board.getCreatedAt();
    }
}
