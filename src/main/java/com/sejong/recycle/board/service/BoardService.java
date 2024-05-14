package com.sejong.recycle.board.service;

import com.sejong.recycle.board.Board;
import com.sejong.recycle.board.BoardType;
import com.sejong.recycle.board.dto.*;
import com.sejong.recycle.board.exception.AccessDenyException;
import com.sejong.recycle.board.exception.ResourceNotFoundException;

import java.util.List;

public interface BoardService {

    public Board createBoard(BoardCreateDto boardCreateDto, BoardType boardType);
    public List<BoardListDto> getBoardList();
    public BoardResDto getBoard(Long id) throws ResourceNotFoundException;
    public BoardResDto updateBoard(Long id, BoardCreateDto boardCreateDto, BoardType boardType) throws ResourceNotFoundException, AccessDenyException;
    public String deleteBoard(Long id, PasswordDto passwordDto) throws ResourceNotFoundException;

    public List<BoardListDto> getBoardListByType(BoardType boardType);

    List<BoardMapListDto> getBoardMapList();
}
