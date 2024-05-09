package com.sejong.recycle.board.repository;

import com.sejong.recycle.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
