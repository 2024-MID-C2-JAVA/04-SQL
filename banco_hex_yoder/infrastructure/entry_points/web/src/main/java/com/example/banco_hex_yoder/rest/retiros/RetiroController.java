package com.example.banco_hex_yoder.rest.retiros;

import com.example.banco_hex_yoder.encriptacion.EncripcionService;
import com.example.banco_hex_yoder.dtos.retiroDTO.RetiroRequestDTO;
import com.example.banco_hex_yoder.dtos.retiroDTO.RetiroResponseDTO;
import com.example.banco_hex_yoder.handlers.retiros.RetiroHandler;
import com.example.banco_hex_yoder.model.Account;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/retiros")
public class RetiroController {

    private final RetiroHandler retiroHandler;
    private final EncripcionService encripcionService;

    public RetiroController(RetiroHandler retiroHandler, EncripcionService encripcionService) {
        this.retiroHandler = retiroHandler;
        this.encripcionService = encripcionService;
    }

    @PostMapping("/cajero")
    public RetiroResponseDTO retirarEnCajero(@RequestBody RetiroRequestDTO request) throws Exception {
        Integer cuentaOrigenNumber = Integer.parseInt(encripcionService.desencriptar(request.getCuentaOrigen()));
        Integer cuentaDestinoNumber = Integer.parseInt(encripcionService.desencriptar(request.getCuentaDestino()));
        BigDecimal monto = request.getMonto();

        Account cuentaActualizada = retiroHandler.ejecutarRetiroCajero(cuentaOrigenNumber, cuentaDestinoNumber, monto);

        return new RetiroResponseDTO(
                encripcionService.encriptar(String.valueOf(cuentaActualizada.getNumber())),
                cuentaActualizada.getAmount()
        );
    }
}
