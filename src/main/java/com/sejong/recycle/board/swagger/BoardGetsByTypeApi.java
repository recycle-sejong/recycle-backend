package com.sejong.recycle.board.swagger;


import com.sejong.recycle.board.dto.BoardListDto;
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
@Operation(summary = "게시글 리스트 조회 (타입별 조회)", description = "등록된 게시글을 타입 별로 조회 (not 페이징)")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "게시글 리스트 조회 성공", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                array = @ArraySchema(schema = @Schema(implementation = BoardListDto.class))
        )
        ),
        @ApiResponse(responseCode = "400", description = "데이터가 존재하지 않을 경우 예외",
                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        examples = {@ExampleObject(value = "게시글을 찾을 수 없습니다.")
                        })
        )
})
public @interface BoardGetsByTypeApi {

}
