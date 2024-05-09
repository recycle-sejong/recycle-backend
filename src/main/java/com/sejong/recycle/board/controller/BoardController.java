package com.sejong.recycle.board.controller;


import com.sejong.recycle.board.Board;
import com.sejong.recycle.board.dto.BoardCreateDto;
import com.sejong.recycle.board.dto.BoardListDto;
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
    public Board createBoard(@RequestBody BoardCreateDto memberCreateDto) {
        return boardService.createBoard(memberCreateDto);
    }


    @BoardGetsApi
    @GetMapping("/boards")
    public List<BoardListDto> getBoards(){
        return boardService.getBoardList();
    }

    @BoardGetApi
    @GetMapping("/boards/{boardId}")
    public Board getBoard(@PathVariable("boardId") Long boardId){
        return boardService.getBoard(boardId);
    }

    @BoardUpdateApi
    @PatchMapping("/boards/{boardId}")
    public Board updateBoard(@PathVariable("boardId") Long boardId,@RequestBody BoardCreateDto boardCreateDto){
        return boardService.updateBoard(boardId, boardCreateDto);
    }

    @BoardDeleteApi
    @DeleteMapping("/boards/{boardId}")
    public String deleteBoard(@PathVariable("boardId") Long boardId){
        return boardService.deleteBoard(boardId);
    }
}
