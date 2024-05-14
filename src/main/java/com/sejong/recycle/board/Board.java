package com.sejong.recycle.board;


import com.sejong.recycle.board.dto.BoardCreateDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String image;

    private String nickname;
    private String password;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    private Double latitude; //위도
    private Double longitude; //경도

    @CreatedDate
    private LocalDateTime createdAt;

    public Board(BoardCreateDto boardCreateDto, BoardType boardType, String password) {
        this.title = boardCreateDto.getTitle();
        this.content = boardCreateDto.getContent();
        this.image = boardCreateDto.getImage();
        this.nickname = boardCreateDto.getNickname();
        this.password = password;
        this.latitude = boardCreateDto.getLatitude();
        this.longitude = boardCreateDto.getLongitude();
        this.boardType = boardType;
    }

    public void updateBoard(BoardCreateDto boardCreateDto, BoardType boardType) {
        this.title = boardCreateDto.getTitle();
        this.content = boardCreateDto.getContent();
        this.image = boardCreateDto.getImage();
        this.nickname = boardCreateDto.getNickname();
        this.latitude = boardCreateDto.getLatitude();
        this.longitude = boardCreateDto.getLongitude();
        this.boardType = boardType;
    }
}
