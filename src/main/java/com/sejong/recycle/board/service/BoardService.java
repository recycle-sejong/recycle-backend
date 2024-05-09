package com.sejong.recycle.board.service;

import com.sejong.recycle.board.Board;
import com.sejong.recycle.board.dto.BoardCreateDto;
import com.sejong.recycle.board.dto.BoardListDto;
import com.sejong.recycle.board.exception.ResourceNotFoundException;

import java.util.List;

public interface BoardService {

    public Board createBoard(BoardCreateDto boardCreateDto);
    public List<BoardListDto> getBoardList();
    public Board getBoard(Long id) throws ResourceNotFoundException;
    public Board updateBoard(Long id, BoardCreateDto boardCreateDto) throws ResourceNotFoundException;
    public String deleteBoard(Long id) throws ResourceNotFoundException;
}
