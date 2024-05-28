package com.sejong.recycle.board.service;

import com.sejong.recycle.board.Board;
import com.sejong.recycle.board.dto.*;
import com.sejong.recycle.board.exception.AccessDenyException;
import com.sejong.recycle.board.exception.ResourceNotFoundException;

import java.util.List;

public interface BoardService {

    public Board createBoard(BoardCreateDto boardCreateDto);
    public BoardPageDto getBoardList(Integer page, Integer size);
    public BoardResDto getBoard(Long id) throws ResourceNotFoundException;
    public BoardResDto updateBoard(Long id, BoardCreateDto boardCreateDto) throws ResourceNotFoundException, AccessDenyException;
    public String deleteBoard(Long id, PasswordDto passwordDto) throws ResourceNotFoundException;


    List<BoardMapListDto> getBoardMapList();
}
