package com.sejong.recycle.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateDto {
    private String title;
    private String content;
    private String image;
    private Double latitude; //위도
    private Double longitude; //경도
}
