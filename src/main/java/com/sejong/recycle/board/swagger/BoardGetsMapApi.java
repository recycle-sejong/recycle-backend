package com.sejong.recycle.board.swagger;

import com.sejong.recycle.board.dto.BoardListDto;
import com.sejong.recycle.board.dto.BoardMapListDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "게시글 리스트 조회 (지도 에서 조회)", description = "등록된 게시글을 전체 조회 (not 페이징)")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "게시글 리스트 조회 성공", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                array = @ArraySchema(schema = @Schema(implementation = BoardMapListDto.class))
        ))
})
public @interface BoardGetsMapApi {
}
