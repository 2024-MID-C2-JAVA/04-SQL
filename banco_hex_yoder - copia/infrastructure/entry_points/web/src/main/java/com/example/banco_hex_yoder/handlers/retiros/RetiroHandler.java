package com.example.banco_hex_yoder.handlers.retiros;

import com.example.banco_hex_yoder.dtos.retiroDTO.RetiroRequestDTO;
import com.example.banco_hex_yoder.dtos.retiroDTO.RetiroResponseDTO;
import com.example.banco_hex_yoder.encriptacion.EncripcionService;
import com.example.banco_hex_yoder.gateway.AccountGateway;
import com.example.banco_hex_yoder.model.Account;
import com.example.banco_hex_yoder.usecase.retiros.RetiroEnCajero;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RetiroHandler {

    private final RetiroEnCajero retiroCajero;
    private final AccountGateway accountGateway;
    private final EncripcionService encripcionService;

    public RetiroHandler(RetiroEnCajero retiroCajero, AccountGateway accountGateway, EncripcionService encripcionService) {
        this.retiroCajero = retiroCajero;
        this.accountGateway = accountGateway;
        this.encripcionService = encripcionService;
    }

    public RetiroResponseDTO ejecutarRetiroCajero(RetiroRequestDTO request) {
        try {
            String username = encripcionService.desencriptar(request.getCustomer());
            Integer cuentaOrigenNumber = Integer.parseInt(encripcionService.desencriptar(request.getCuentaOrigen()));
            Account cuentaOrigen = accountGateway.findByNumber(cuentaOrigenNumber)
                    .orElseThrow(() -> new IllegalArgumentException("Cuenta origen no encontrada"));

            if (!accountGateway.esCuentaDeUsuario(cuentaOrigenNumber, username)) {
                throw new IllegalArgumentException("El usuario no es dueño de la cuenta origen");
            }

            Integer cuentaDestinoNumber = Integer.parseInt(encripcionService.desencriptar(request.getCuentaDestino()));
            BigDecimal monto = request.getMonto();
            Account cuentaActualizada = retiroCajero.realizarRetiro(cuentaOrigenNumber, cuentaDestinoNumber, monto);

            return new RetiroResponseDTO(
                    encripcionService.encriptar(String.valueOf(cuentaActualizada.getNumber())),
                    cuentaActualizada.getAmount()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error en el retiro en cajero: " + e.getMessage(), e);
        }
    }
}
