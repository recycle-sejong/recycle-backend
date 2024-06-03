package com.sejong.recycle.comment.dto;


import com.sejong.recycle.comment.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResDto {

    private Long commentId;
    private String content;
    private String writer;

    public CommentResDto(Comment comment) {
        this.commentId = comment.getId();
        this.content = comment.getContent();
        this.writer = comment.getWriter();
    }
}
