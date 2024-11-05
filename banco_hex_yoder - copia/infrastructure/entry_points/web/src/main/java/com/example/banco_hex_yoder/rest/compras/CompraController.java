package com.example.banco_hex_yoder.rest.compras;

import com.example.banco_hex_yoder.dtos.compraDTO.CompraRequestDTO;
import com.example.banco_hex_yoder.dtos.compraDTO.CompraResponseDTO;
import com.example.banco_hex_yoder.handlers.compras.CompraHandler;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    private final CompraHandler compraHandler;

    public CompraController(CompraHandler compraHandler) {
        this.compraHandler = compraHandler;
    }

    @PostMapping("/fisico")
    public CompraResponseDTO comprarEnFisico(@RequestBody CompraRequestDTO request) {
        return compraHandler.ejecutarCompraFisico(request);
    }

    @PostMapping("/web")
    public CompraResponseDTO comprarEnWeb(@RequestBody CompraRequestDTO request) {
        return compraHandler.ejecutarCompraWeb(request);
    }
}
