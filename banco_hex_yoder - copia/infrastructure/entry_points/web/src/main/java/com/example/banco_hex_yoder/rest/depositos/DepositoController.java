package com.example.banco_hex_yoder.rest.depositos;

import com.example.banco_hex_yoder.dtos.depositoDTO.DepositoRequestDTO;
import com.example.banco_hex_yoder.dtos.depositoDTO.DepositoResponseDTO;
import com.example.banco_hex_yoder.handlers.depositos.DepositoHandler;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/depositos")
public class DepositoController {

    private final DepositoHandler depositoHandler;

    public DepositoController(DepositoHandler depositoHandler) {
        this.depositoHandler = depositoHandler;
    }

    @PostMapping("/sucursal")
    public DepositoResponseDTO depositarEnSucursal(@RequestBody DepositoRequestDTO request) {
        return depositoHandler.ejecutarDepositoSucursal(request);
    }

    @PostMapping("/cajero")
    public DepositoResponseDTO depositarEnCajero(@RequestBody DepositoRequestDTO request) {
        return depositoHandler.ejecutarDepositoCajero(request);
    }

    @PostMapping("/otracuenta")
    public DepositoResponseDTO depositarDesdeOtraCuenta(@RequestBody DepositoRequestDTO request) {
        return depositoHandler.ejecutarDepositoOtraCuenta(request);
    }
}
