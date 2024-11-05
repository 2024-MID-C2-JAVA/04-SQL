package com.example.banco_hex_yoder.config.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        String mensaje = ex.getMessage();

        if (mensaje.contains("Cuenta origen no encontrada")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ExcepcionCuentaNoEncontrada: " + mensaje);
        }

        if (mensaje.contains("Cuenta destino no encontrada")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ExcepcionCuentaNoEncontrada: " + mensaje);
        }

        if (mensaje.contains("Saldo insuficiente")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ExcepcionSaldoInsuficiente: " + mensaje);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + mensaje);
    }
}
