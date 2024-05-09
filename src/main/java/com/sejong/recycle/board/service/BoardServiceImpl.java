package com.sejong.recycle.board.service;


import com.sejong.recycle.board.Board;
import com.sejong.recycle.board.dto.BoardCreateDto;
import com.sejong.recycle.board.dto.BoardListDto;
import com.sejong.recycle.board.exception.ResourceNotFoundException;
import com.sejong.recycle.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    public Board createBoard(BoardCreateDto boardCreateDto) {
        return boardRepository.save(new Board(boardCreateDto));
    }

    public List<BoardListDto> getBoardList() {
        return boardRepository.findAll().stream().map(BoardListDto::new).toList();
    }

    public Board getBoard(Long id) throws ResourceNotFoundException{
        return boardRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("게시글"));
    }

    @Transactional
    public Board updateBoard(Long id,BoardCreateDto boardCreateDto) throws ResourceNotFoundException {
        Board board = boardRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("게시글"));
        board.updateBoard(boardCreateDto);
        return board;
    }


    public String deleteBoard(Long id) throws ResourceNotFoundException {
        boardRepository.deleteById(id);
        return "삭제 완료";
    }
}
