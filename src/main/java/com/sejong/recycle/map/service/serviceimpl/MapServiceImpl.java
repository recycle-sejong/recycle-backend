package com.sejong.recycle.map.service.serviceimpl;

import com.sejong.recycle.map.dto.MapDto;
import com.sejong.recycle.map.entity.Category;
import com.sejong.recycle.map.entity.Map;
import com.sejong.recycle.map.exception.CategoryNotFoundException;
import com.sejong.recycle.map.exception.MapNotFoundException;
import com.sejong.recycle.map.repository.CategoryRepository;
import com.sejong.recycle.map.repository.MapRepository;
import com.sejong.recycle.map.service.serviceinterface.MapService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapService {
    private final MapRepository mapRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public MapDto getMap(Long mapId) throws MapNotFoundException{
        final Map map = mapRepository.findById(mapId)
                .orElseThrow(()->new MapNotFoundException("지도 정보"));

        return MapDto.builder()
                .mapId(mapId)
                .address(map.getAddress())
                .name(map.getName())
                .latitude(map.getLatitude())
                .longitude(map.getLongitude())
                .categoryId(map.getCategory().getCategoryId())
                .categoryName(map.getCategory().getCategoryName())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MapDto> getAllMaps() {
        List<Map> maps = mapRepository.findAll();

        return maps.stream().map(map -> MapDto.builder()
                        .mapId(map.getMapId())
                        .address(map.getAddress())
                        .name(map.getName())
                        .latitude(map.getLatitude())
                        .longitude(map.getLongitude())
                        .categoryId(map.getCategory().getCategoryId())
                        .categoryName(map.getCategory().getCategoryName())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<MapDto> getMapsByCategoryId(Long categoryId) {
        final Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("카테고리 정보"));
        final List<Map> maps = mapRepository.findByCategory(category);

        final List<MapDto> result = new ArrayList<>();
        for (Map map : maps) {
            final MapDto dto = MapDto.builder()
                    .mapId(map.getMapId())
                    .address(map.getAddress())
                    .name(map.getName())
                    .latitude(map.getLatitude())
                    .longitude(map.getLongitude())
                    .categoryId(map.getCategory().getCategoryId())
                    .categoryName(map.getCategory().getCategoryName())
                    .build();
            result.add(dto);
        }
        return result;
    }
}
