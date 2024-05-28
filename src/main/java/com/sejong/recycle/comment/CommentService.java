package com.sejong.recycle.comment;

import com.sejong.recycle.board.Board;
import com.sejong.recycle.board.exception.AccessDenyException;
import com.sejong.recycle.board.exception.ResourceNotFoundException;
import com.sejong.recycle.board.repository.BoardRepository;
import com.sejong.recycle.comment.dto.CommentDto;
import com.sejong.recycle.comment.dto.CommentUpdateDto;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;


    public Comment addComment(Long id,CommentDto commentDto)throws ResourceNotFoundException {
        Board board = boardRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("게시글"));
        return commentRepository.save(new Comment(commentDto, board));
    }

    @Transactional
    public Comment updateComment(Long commentId, CommentUpdateDto contentDto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(()->new ResourceNotFoundException("댓글"));
        if (!BCrypt.checkpw(contentDto.getPassword(), comment.getPassword())){
            throw new AccessDenyException("권한이 없습니다.");
        }
        comment.updateContent(contentDto.getContent());
        return comment;
    }
}
