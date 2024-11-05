package com.example.banco_hex_yoder.handlers.compras;

import com.example.banco_hex_yoder.dtos.compraDTO.CompraRequestDTO;
import com.example.banco_hex_yoder.dtos.compraDTO.CompraResponseDTO;
import com.example.banco_hex_yoder.encriptacion.EncripcionService;
import com.example.banco_hex_yoder.gateway.AccountGateway;
import com.example.banco_hex_yoder.model.Account;
import com.example.banco_hex_yoder.usecase.compras.CompraEstablecimientoFisico;
import com.example.banco_hex_yoder.usecase.compras.CompraPaginaWeb;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CompraHandler {

    private final CompraEstablecimientoFisico compraFisico;
    private final CompraPaginaWeb compraWeb;
    private final AccountGateway accountGateway;
    private final EncripcionService encripcionService;

    public CompraHandler(CompraEstablecimientoFisico compraFisico, CompraPaginaWeb compraWeb,
                         AccountGateway accountGateway, EncripcionService encripcionService) {
        this.compraFisico = compraFisico;
        this.compraWeb = compraWeb;
        this.accountGateway = accountGateway;
        this.encripcionService = encripcionService;
    }

    public CompraResponseDTO ejecutarCompraFisico(CompraRequestDTO request) {
        try {
            String username = encripcionService.desencriptar(request.getCustomer());
            Integer cuentaOrigenNumber = Integer.parseInt(encripcionService.desencriptar(request.getCuentaOrigen()));
            Account cuentaOrigen = accountGateway.findByNumber(cuentaOrigenNumber)
                    .orElseThrow(() -> new IllegalArgumentException("Cuenta origen no encontrada"));

            if (!accountGateway.esCuentaDeUsuario(cuentaOrigenNumber, username)) {
                throw new IllegalArgumentException("El usuario no es dueño de la cuenta origen");
            }

            BigDecimal monto = request.getMonto();
            Account cuentaActualizada = compraFisico.realizarCompra(cuentaOrigenNumber, monto);

            return new CompraResponseDTO(
                    encripcionService.encriptar(String.valueOf(cuentaActualizada.getNumber())),
                    cuentaActualizada.getAmount()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error en la compra en establecimiento físico: " + e.getMessage(), e);
        }
    }

    public CompraResponseDTO ejecutarCompraWeb(CompraRequestDTO request) {
        try {
            String username = encripcionService.desencriptar(request.getCustomer());
            Integer cuentaOrigenNumber = Integer.parseInt(encripcionService.desencriptar(request.getCuentaOrigen()));
            Account cuentaOrigen = accountGateway.findByNumber(cuentaOrigenNumber)
                    .orElseThrow(() -> new IllegalArgumentException("Cuenta origen no encontrada"));

            if (!accountGateway.esCuentaDeUsuario(cuentaOrigenNumber, username)) {
                throw new IllegalArgumentException("El usuario no es dueño de la cuenta origen");
            }

            BigDecimal monto = request.getMonto();
            Account cuentaActualizada = compraWeb.realizarCompra(cuentaOrigenNumber, monto);

            return new CompraResponseDTO(
                    encripcionService.encriptar(String.valueOf(cuentaActualizada.getNumber())),
                    cuentaActualizada.getAmount()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error en la compra en página web: " + e.getMessage(), e);
        }
    }
}
