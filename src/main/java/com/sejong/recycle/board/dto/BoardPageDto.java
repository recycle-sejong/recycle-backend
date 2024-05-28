package com.sejong.recycle.board.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class BoardPageDto {
    private PageInfo pageInfo;
    private List<BoardListDto> boardListDto;

    public BoardPageDto(PageInfo pageInfo, List<BoardListDto> boardListDto) {
        this.pageInfo = pageInfo;
        this.boardListDto = boardListDto;
    }
}
