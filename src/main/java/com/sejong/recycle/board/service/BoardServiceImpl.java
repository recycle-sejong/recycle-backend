package com.sejong.recycle.board.service;


import com.sejong.recycle.board.Board;
import com.sejong.recycle.board.BoardType;
import com.sejong.recycle.board.dto.*;
import com.sejong.recycle.board.exception.AccessDenyException;
import com.sejong.recycle.board.exception.ResourceNotFoundException;
import com.sejong.recycle.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    public Board createBoard(BoardCreateDto boardCreateDto, BoardType boardType) {
        return boardRepository.save(new Board(boardCreateDto, boardType, BCrypt.hashpw(boardCreateDto.getPassword(), BCrypt.gensalt())));
    }

    public List<BoardListDto> getBoardList() {
        return boardRepository.findAll().stream().map(BoardListDto::new).toList();
    }


    public List<BoardListDto> getBoardListByType(BoardType boardType) {
        return boardRepository.findAllByBoardType(boardType).stream().map(BoardListDto::new).toList();
    }

    public BoardResDto getBoard(Long id) throws ResourceNotFoundException{
        return new BoardResDto(boardRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("게시글")));
    }

    @Override
    public List<BoardMapListDto> getBoardMapList() {
        return boardRepository.findAll().stream().map(BoardMapListDto::new).toList();
    }

    @Transactional
    public BoardResDto updateBoard(Long id,BoardCreateDto boardCreateDto, BoardType boardType) throws ResourceNotFoundException, AccessDenyException {
        Board board = boardRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("게시글"));
        if (!BCrypt.checkpw(boardCreateDto.getPassword(), board.getPassword())){
            throw new AccessDenyException("권한이 없습니다.");
        }
        board.updateBoard(boardCreateDto, boardType);
        return new BoardResDto(board);
    }


    public String deleteBoard(Long id, PasswordDto passwordDto) throws ResourceNotFoundException {
        Board board = boardRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("게시글"));
        if (!BCrypt.checkpw(passwordDto.getPassword(), board.getPassword())){
            throw new AccessDenyException("권한이 없습니다.");
        }
        boardRepository.deleteById(id);
        return "삭제 완료";
    }


}
