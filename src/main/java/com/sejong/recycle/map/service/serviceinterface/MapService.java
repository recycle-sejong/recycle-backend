package com.sejong.recycle.map.service.serviceinterface;

import com.sejong.recycle.map.dto.MapDto;

import java.util.List;

public interface MapService {
    MapDto getMap(Long mapId);
    List<MapDto> getAllMaps();
    List<MapDto> getMapsByCategoryId(Long categoryId);
}
