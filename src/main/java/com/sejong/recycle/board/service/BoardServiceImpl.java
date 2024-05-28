package com.sejong.recycle.board.service;


import com.sejong.recycle.board.Board;
import com.sejong.recycle.board.dto.*;
import com.sejong.recycle.board.exception.AccessDenyException;
import com.sejong.recycle.board.exception.ResourceNotFoundException;
import com.sejong.recycle.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;

    public Board createBoard(BoardCreateDto boardCreateDto) {
        return boardRepository.save(new Board(boardCreateDto, BCrypt.hashpw(boardCreateDto.getPassword(), BCrypt.gensalt())));
    }

    public BoardPageDto getBoardList(Integer page, Integer size) {
        Page<Board> boards = boardRepository.findAll(PageRequest.of(page, size,Sort.by(Sort.Direction.DESC,"createdAt")));

        PageInfo pageInfo= PageInfo.builder()
                .page(page)
                .pageSize(size)
                .totalPages(boards.getTotalPages())
                .totalNumber(boards.getTotalElements())
                .build();

        List<BoardListDto> response = boards.getContent().stream().map(BoardListDto::new)
                .toList();

        return new BoardPageDto(pageInfo, response);
    }



    public BoardResDto getBoard(Long id) throws ResourceNotFoundException{
        return new BoardResDto(boardRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("게시글")));
    }

    @Override
    public List<BoardMapListDto> getBoardMapList() {
        return boardRepository.findAll().stream().map(BoardMapListDto::new).toList();
    }

    @Transactional
    public BoardResDto updateBoard(Long id,BoardCreateDto boardCreateDto) throws ResourceNotFoundException, AccessDenyException {
        Board board = boardRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("게시글"));
        if (!BCrypt.checkpw(boardCreateDto.getPassword(), board.getPassword())){
            throw new AccessDenyException("권한이 없습니다.");
        }
        board.updateBoard(boardCreateDto);
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
