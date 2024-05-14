package com.sejong.recycle.map.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "지도 정보")
public class MapDto {
    private Long mapId;
    private String address;
    private String name;
    private Double latitude;
    private Double longitude;
    private Long categoryId;
    private String categoryName;
}
