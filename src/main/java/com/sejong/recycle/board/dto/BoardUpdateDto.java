package com.sejong.recycle.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateDto {
    private BoardCreateDto boardCreateDto;
    private PasswordDto passwordDto;
}
