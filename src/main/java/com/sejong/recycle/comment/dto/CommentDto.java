package com.sejong.recycle.comment.dto;


import com.sejong.recycle.comment.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentDto {

    private String content;
    private String writer;
    private String password;

    public CommentDto(Comment comment) {
        this.content = comment.getContent();
        this.writer = comment.getWriter();
    }
}
