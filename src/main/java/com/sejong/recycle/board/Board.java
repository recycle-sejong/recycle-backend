package com.sejong.recycle.board;


import com.sejong.recycle.board.dto.BoardCreateDto;
import com.sejong.recycle.comment.Comment;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "varchar(1000)")
    private String content;


    @Column(columnDefinition = "varchar(1000)")
    private String image;

    private String nickname;
    private String password;

    private Double latitude; //위도
    private Double longitude; //경도

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @CreatedDate
    private LocalDateTime createdAt;

    public Board(BoardCreateDto boardCreateDto, String password) {
        this.title = boardCreateDto.getTitle();
        this.content = boardCreateDto.getContent();
        this.image = boardCreateDto.getImage();
        this.nickname = boardCreateDto.getNickname();
        this.password = password;
        this.latitude = boardCreateDto.getLatitude();
        this.longitude = boardCreateDto.getLongitude();
    }

    public void updateBoard(BoardCreateDto boardCreateDto, String password) {
        this.title = boardCreateDto.getTitle();
        this.content = boardCreateDto.getContent();
        this.image = boardCreateDto.getImage();
        this.nickname = boardCreateDto.getNickname();
        this.password = password;
        this.latitude = boardCreateDto.getLatitude();
        this.longitude = boardCreateDto.getLongitude();
    }
}
