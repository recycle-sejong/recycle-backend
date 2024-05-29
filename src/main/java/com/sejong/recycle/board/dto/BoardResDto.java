package com.sejong.recycle.board.dto;


import com.sejong.recycle.board.Board;
import com.sejong.recycle.comment.dto.CommentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class BoardResDto {
    private Long boardId;

    private String title;

    private String content;

    private String image;

    private String nickname;

    private Double latitude; //위도
    private Double longitude; //경도
    private LocalDateTime createdAt;


    public BoardResDto(Board board) {
        this.boardId = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.image = board.getImage();
        this.nickname = board.getNickname();
        this.latitude = board.getLatitude();
        this.longitude = board.getLongitude();
        this.createdAt = board.getCreatedAt();
    }
}
