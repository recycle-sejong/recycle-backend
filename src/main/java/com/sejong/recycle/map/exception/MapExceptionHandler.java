package com.sejong.recycle.map.exception;

import com.sejong.recycle.board.exception.ResourceNotFoundException;
import com.sejong.recycle.map.controller.MapController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = MapController.class)
public class MapExceptionHandler {
    @ExceptionHandler(MapNotFoundException.class)
    public ResponseEntity<String> handleMapNotFoundException(MapNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage()+"를 찾을 수 없습니다.");
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFoundException(CategoryNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage()+"를 찾을 수 없습니다.");
    }
}
