package com.sejong.recycle.comment;


import com.sejong.recycle.comment.dto.CommentDto;
import com.sejong.recycle.comment.dto.CommentUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;


    @PostMapping()
    public Comment addComment(@RequestParam("{boardId}") Long id,
                              @RequestBody CommentDto commentDto) {
        return commentService.addComment(id,commentDto);
    }

    @PatchMapping("{commentId}")
    public Comment updateComment(@PathVariable("commentId") Long commentId,
                                 @RequestBody CommentUpdateDto contentDto) {
        return commentService.updateComment(commentId, contentDto);
    }

}
