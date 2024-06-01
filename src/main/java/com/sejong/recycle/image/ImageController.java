package com.sejong.recycle.image;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Tag(name = "이미지 업로드", description = "이미지를 먼저 업로드")
public class ImageController {

    private final ImageService imageService;

    /** 해당 bucket의 aiinfo에 사진을 저장 */
    @PostMapping(value = "/api/images",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> uploadAiInfoImage(
            @RequestParam(value = "image",required = true) MultipartFile files){
        try {
            ImageDto image = imageService.upload(files, "sejong");
            return ResponseEntity.status(HttpStatus.OK).body(image);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
