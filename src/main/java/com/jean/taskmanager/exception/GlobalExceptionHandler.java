package com.jean.taskmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(
            HttpMessageNotReadableException ex) {
        Map<String, String> error = new HashMap<>();
        
        if (ex.getMessage() != null && ex.getMessage().contains("Required request body is missing")) {
            error.put("erro", "Corpo da requisição é obrigatório");
            error.put("mensagem", "Esta operação requer um corpo JSON na requisição");
        } else {
            error.put("erro", "Erro ao processar o corpo da requisição");
            error.put("mensagem", ex.getMessage() != null ? ex.getMessage() : "Formato JSON inválido");
        }
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(RegraNegocioException.class)
    public ResponseEntity<Map<String, String>> handleRegraNegocioException(RegraNegocioException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("erro", "Erro de regra de negócio");
        error.put("mensagem", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("erro", "Erro interno");
        error.put("mensagem", ex.getMessage() != null ? ex.getMessage() : "Ocorreu um erro inesperado");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
