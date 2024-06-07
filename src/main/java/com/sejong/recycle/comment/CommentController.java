package com.sejong.recycle.comment;


import com.sejong.recycle.board.dto.PasswordDto;
import com.sejong.recycle.comment.dto.CommentDto;
import com.sejong.recycle.comment.dto.CommentResDto;
import com.sejong.recycle.comment.dto.CommentUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;


    @PostMapping("/comments")
    public Comment addComment(@RequestParam("{boardId}") Long id,
                              @RequestBody CommentDto commentDto) {
        return commentService.addComment(id,commentDto);
    }

    @PatchMapping("/comments/{commentId}")
    public Comment updateComment(@PathVariable("commentId") Long commentId,
                                 @RequestBody CommentUpdateDto commentUpdateDto) {
        return commentService.updateComment(commentId, commentUpdateDto);
    }

    @GetMapping("/boards/{boardId}/comments")
    public List<CommentResDto> getComments(@PathVariable("boardId") Long boardId) {
        return commentService.getComment(boardId);
    }

    @DeleteMapping("/comments/{commentId}")
    public String deleteComment(@PathVariable("commentId") Long commentId,
                                @RequestBody PasswordDto passwordDto) {
        return commentService.deleteComment(commentId, passwordDto);
    }

    @PostMapping("/comments/password")
    public PasswordDto checkPassword(@RequestParam("commentId")Long commentId,
                                     @RequestBody PasswordDto passwordDto) {
        return commentService.checkPassword(commentId,passwordDto);
    }

}
