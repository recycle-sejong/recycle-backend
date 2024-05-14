package com.sejong.recycle.board.controller;


import com.sejong.recycle.board.Board;
import com.sejong.recycle.board.BoardType;
import com.sejong.recycle.board.dto.*;
import com.sejong.recycle.board.service.BoardService;
import com.sejong.recycle.board.swagger.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "게시판 API")
public class BoardController {
    private final BoardService boardService;


    @BoardCreateApi
    @PostMapping("/board")
    public Board createBoard(@RequestBody BoardCreateDto memberCreateDto,
                             @RequestParam("boardType") BoardType boardType) {
        return boardService.createBoard(memberCreateDto,boardType);
    }


    @BoardGetsApi
    @GetMapping("/boards")
    public List<BoardListDto> getBoards(){
        return boardService.getBoardList();
    }

    @BoardGetsByTypeApi
    @GetMapping("/boards/type")
    public List<BoardListDto> getBoardsCategory(@RequestParam("boardType") BoardType boardType){
        return boardService.getBoardListByType(boardType);
    }

    @BoardGetsMapApi
    @GetMapping("/boards/map")
    public List<BoardMapListDto> getBoardMap(){
        return boardService.getBoardMapList();
    }


    @BoardGetApi
    @GetMapping("/boards/{boardId}")
    public BoardResDto getBoard(@PathVariable("boardId") Long boardId){
        return boardService.getBoard(boardId);
    }

    @BoardUpdateApi
    @PatchMapping("/boards/{boardId}")
    public BoardResDto updateBoard(@PathVariable("boardId") Long boardId,
                                   @RequestBody BoardCreateDto boardCreateDto,
                                   @RequestParam("boardType") BoardType boardType){
        return boardService.updateBoard(boardId, boardCreateDto, boardType);
    }


    @BoardDeleteApi
    @DeleteMapping("/boards/{boardId}")
    public String deleteBoard(@PathVariable("boardId") Long boardId,
                              @RequestBody PasswordDto passwordDto){
        return boardService.deleteBoard(boardId,passwordDto);
    }
}
