package com.example.ms_ventas_transacciones.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Esta anotación captura automáticamente cualquier RuntimeException lanzada en tu VentaService
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> manejarExcepciones(RuntimeException e) {

        // Si el error contiene la palabra "no existe", devolvemos un 404 (Not Found)
        if (e.getMessage().contains("no existe")) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        // Si es cualquier otro error, devolvemos un 400 (Bad Request)
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}