package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.handlers;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.rest.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorDTO> handleDomainException(DomainException ex) {
        ErrorDTO error = new ErrorDTO(
            HttpStatus.BAD_REQUEST.value(),
            ex.getMessage(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorDTO error = new ErrorDTO(
            HttpStatus.BAD_REQUEST.value(),
            "ID inválido: " + ex.getMessage(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
