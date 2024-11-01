package com.example.banco_hex_yoder.rest.depositos;

import com.example.banco_hex_yoder.encriptacion.EncripcionService;
import com.example.banco_hex_yoder.dtos.depositoDTO.DepositoRequestDTO;
import com.example.banco_hex_yoder.dtos.depositoDTO.DepositoResponseDTO;
import com.example.banco_hex_yoder.handlers.depositos.DepositoHandler;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/depositos")
public class DepositoController {

    private final DepositoHandler depositoHandler;
    private final EncripcionService encripcionService;

    public DepositoController(DepositoHandler depositoHandler, EncripcionService encripcionService) {
        this.depositoHandler = depositoHandler;
        this.encripcionService = encripcionService;
    }

    @PostMapping("/sucursal")
    public DepositoResponseDTO depositarEnSucursal(@RequestBody DepositoRequestDTO request) throws Exception {
        Integer cuentaOrigenNumber = Integer.parseInt(encripcionService.desencriptar(request.getCuentaOrigen()));
        Integer cuentaDestinoNumber = Integer.parseInt(encripcionService.desencriptar(request.getCuentaDestino()));
        BigDecimal monto = request.getMonto();

        var cuentaDestinoActualizada = depositoHandler.ejecutarDepositoSucursal(cuentaOrigenNumber, cuentaDestinoNumber, monto);

        return new DepositoResponseDTO(
                encripcionService.encriptar(String.valueOf(cuentaDestinoActualizada.getNumber())),
                cuentaDestinoActualizada.getAmount()
        );
    }

    @PostMapping("/cajero")
    public DepositoResponseDTO depositarEnCajero(@RequestBody DepositoRequestDTO request) throws Exception {
        Integer cuentaOrigenNumber = Integer.parseInt(encripcionService.desencriptar(request.getCuentaOrigen()));
        Integer cuentaDestinoNumber = Integer.parseInt(encripcionService.desencriptar(request.getCuentaDestino()));
        BigDecimal monto = request.getMonto();

        var cuentaDestinoActualizada = depositoHandler.ejecutarDepositoCajero(cuentaOrigenNumber, cuentaDestinoNumber, monto);

        return new DepositoResponseDTO(
                encripcionService.encriptar(String.valueOf(cuentaDestinoActualizada.getNumber())),
                cuentaDestinoActualizada.getAmount()
        );
    }

    @PostMapping("/otracuenta")
    public DepositoResponseDTO depositarDesdeOtraCuenta(@RequestBody DepositoRequestDTO request) throws Exception {
        Integer cuentaOrigenNumber = Integer.parseInt(encripcionService.desencriptar(request.getCuentaOrigen()));
        Integer cuentaDestinoNumber = Integer.parseInt(encripcionService.desencriptar(request.getCuentaDestino()));
        BigDecimal monto = request.getMonto();

        var cuentaDestinoActualizada = depositoHandler.ejecutarDepositoOtraCuenta(cuentaOrigenNumber, cuentaDestinoNumber, monto);

        return new DepositoResponseDTO(
                encripcionService.encriptar(String.valueOf(cuentaDestinoActualizada.getNumber())),
                cuentaDestinoActualizada.getAmount()
        );
    }
}
