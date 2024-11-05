package com.example.banco_hex_yoder.rest.retiros;

import com.example.banco_hex_yoder.dtos.retiroDTO.RetiroRequestDTO;
import com.example.banco_hex_yoder.dtos.retiroDTO.RetiroResponseDTO;
import com.example.banco_hex_yoder.handlers.retiros.RetiroHandler;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/retiros")
public class RetiroController {

    private final RetiroHandler retiroHandler;

    public RetiroController(RetiroHandler retiroHandler) {
        this.retiroHandler = retiroHandler;
    }

    @PostMapping("/cajero")
    public RetiroResponseDTO retirarEnCajero(@RequestBody RetiroRequestDTO request) {
        return retiroHandler.ejecutarRetiroCajero(request);
    }
}
