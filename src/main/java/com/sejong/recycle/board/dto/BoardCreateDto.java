package com.sejong.recycle.board.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardCreateDto {

    private String title;
    private String content;
    private String image;

}
