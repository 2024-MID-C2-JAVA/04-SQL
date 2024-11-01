package com.example.banco_hex_yoder.rest.compras;

import com.example.banco_hex_yoder.encriptacion.EncripcionService;
import com.example.banco_hex_yoder.dtos.compraDTO.CompraRequestDTO;
import com.example.banco_hex_yoder.dtos.compraDTO.CompraResponseDTO;
import com.example.banco_hex_yoder.handlers.compras.CompraHandler;
import com.example.banco_hex_yoder.model.Account;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    private final CompraHandler compraHandler;
    private final EncripcionService encripcionService;

    public CompraController(CompraHandler compraHandler, EncripcionService encripcionService) {
        this.compraHandler = compraHandler;
        this.encripcionService = encripcionService;
    }

    @PostMapping("/fisico")
    public CompraResponseDTO comprarEnFisico(@RequestBody CompraRequestDTO request) throws Exception {
        Integer cuentaOrigenNumber = Integer.parseInt(encripcionService.desencriptar(request.getCuentaOrigen()));
        BigDecimal monto = request.getMonto();

        Account cuentaActualizada = compraHandler.ejecutarCompraFisico(cuentaOrigenNumber, monto);

        return new CompraResponseDTO(
                encripcionService.encriptar(String.valueOf(cuentaActualizada.getNumber())),
                cuentaActualizada.getAmount()
        );
    }
}
