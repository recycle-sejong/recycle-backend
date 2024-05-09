package com.sejong.recycle.board.swagger;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "게시글 삭제", description = "게시글 id로 게시글 삭제")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "삭제 완료되었습니다.",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {@ExampleObject(value = "삭제완료")})),
        @ApiResponse(responseCode = "400", description = "게시글이 존재하지 않을 경우",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {@ExampleObject(value = "게시글을 찾을 수 없습니다.")}))
})
public @interface BoardDeleteApi {
}
