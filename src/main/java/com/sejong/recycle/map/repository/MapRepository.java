package com.sejong.recycle.map.repository;

import com.sejong.recycle.map.entity.Category;
import com.sejong.recycle.map.entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MapRepository extends JpaRepository<Map, Long> {
    List<Map> findByCategory(Category category);
}
