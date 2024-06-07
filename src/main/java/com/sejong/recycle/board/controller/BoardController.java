package com.sejong.recycle.board.controller;


import com.sejong.recycle.board.Board;
import com.sejong.recycle.board.dto.*;
import com.sejong.recycle.board.service.BoardService;
import com.sejong.recycle.board.swagger.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "게시판 API")
@Slf4j
public class BoardController {
    private final BoardService boardService;


    @BoardCreateApi
    @PostMapping("/board")
    public Board createBoard(@RequestBody BoardCreateDto memberCreateDto) {
        return boardService.createBoard(memberCreateDto);
    }


    @BoardGetsApi
    @GetMapping("/boards")
    public BoardPageDto getBoards(@RequestParam("page")  Integer page,
                                  @RequestParam("size") Integer size){
        return boardService.getBoardList(page, size);
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
                                   @RequestBody BoardUpdateDto boardUpdateDto){
        return boardService.updateBoard(boardId, boardUpdateDto);
    }


    @BoardDeleteApi
    @DeleteMapping("/boards/{boardId}")
    public String deleteBoard(@PathVariable("boardId") Long boardId,
                              @RequestBody PasswordDto passwordDto){
        return boardService.deleteBoard(boardId,passwordDto);
    }

    @PostMapping("/boards/password")
    public PasswordDto checkPassword(@RequestParam("boardId") Long boardId,
                                     @RequestBody PasswordDto passwordDto) {
        return boardService.checkPassword(boardId,passwordDto);
    }
}
