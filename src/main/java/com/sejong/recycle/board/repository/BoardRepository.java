package com.sejong.recycle.board.repository;

import com.sejong.recycle.board.Board;
import com.sejong.recycle.board.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByBoardType(BoardType boardType);
}
