package com.sejong.recycle.board.dto;


import com.sejong.recycle.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardMapListDto {
    private Long id;

    private Double latitude; //위도
    private Double longitude; //경도

    public BoardMapListDto(Board board) {
        this.id =board.getId();

        this.latitude = board.getLatitude();
        this.longitude = board.getLongitude();
    }
}
