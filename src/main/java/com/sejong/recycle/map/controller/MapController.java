package com.sejong.recycle.map.controller;

import com.sejong.recycle.map.dto.MapDto;
import com.sejong.recycle.map.service.serviceinterface.MapService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Tag(name = "지도 API")
public class MapController {
    private final MapService mapService;

    @Operation(summary = "지도 전체 조회")
    @GetMapping("/maps")
    public List<MapDto> getAllMaps(){
        return mapService.getAllMaps();
    }

    @Operation(summary = "지도 개별 조회")
    @GetMapping("/maps/{mapId}")
    public MapDto getMap(@PathVariable("mapId") Long mapId){
        return mapService.getMap(mapId);
}

    @Operation(summary = "카테고리별 지도 조회")
    @GetMapping("/category/{categoryId}")
    public List<MapDto> getMapsByCategory(@PathVariable("categoryId") Long categoryId) {
        return mapService.getMapsByCategoryId(categoryId);
    }
}
