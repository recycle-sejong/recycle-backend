package com.sejong.recycle.board.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardCreateDto {

    private String title;
    private String content;
    private String image;
    private String nickname;
    private String password;
    private Double latitude; //위도
    private Double longitude; //경도

}
