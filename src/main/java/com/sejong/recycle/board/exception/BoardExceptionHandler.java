package com.sejong.recycle.board.exception;


import com.sejong.recycle.board.controller.BoardController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = BoardController.class)
public class BoardExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage()+"을 찾을 수 없습니다.");
    }

    @ExceptionHandler(AccessDenyException.class)
    public ResponseEntity<String> handleAccessDenyException(AccessDenyException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
