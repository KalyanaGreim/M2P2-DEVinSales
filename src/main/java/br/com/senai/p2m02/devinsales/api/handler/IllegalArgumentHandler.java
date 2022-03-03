package br.com.senai.p2m02.devinsales.api.handler;

import br.com.senai.p2m02.devinsales.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class IllegalArgumentHandler {

    @ExceptionHandler({ IllegalArgumentException.class })
    public ResponseEntity<ErrorResponse> illegalArgument(IllegalArgumentException e) {

        ErrorResponse error = new ErrorResponse();
        error.setCode(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(LocalDateTime.now());
        error.getMessages().add(e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
