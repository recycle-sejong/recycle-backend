package com.sejong.recycle.comment;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sejong.recycle.board.Board;
import com.sejong.recycle.comment.dto.CommentDto;
import com.sejong.recycle.comment.dto.CommentUpdateDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String writer;
    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardId")
    @JsonIgnore
    private Board board;

    @CreatedDate
    private LocalDateTime createTime;

    public Comment(CommentDto commentDto, Board board) {
        this.content = commentDto.getContent();
        this.writer = commentDto.getWriter();
        this.password = BCrypt.hashpw(commentDto.getPassword(), BCrypt.gensalt());
        this.board = board;
    }

    public void updateComment(CommentUpdateDto commentUpdateDto) {
        this.content = commentUpdateDto.getContent();

    }
}
