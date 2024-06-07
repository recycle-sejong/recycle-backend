package com.sejong.recycle.comment.dto;

import com.sejong.recycle.board.dto.PageInfo;
import com.sejong.recycle.board.dto.PasswordDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentUpdateDto {
    private CommentDto comment;
    private PasswordDto passwordDto;
}
