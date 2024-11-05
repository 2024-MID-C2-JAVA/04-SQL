package com.example.banco_hex_yoder.handlers.depositos;

import com.example.banco_hex_yoder.dtos.depositoDTO.DepositoRequestDTO;
import com.example.banco_hex_yoder.dtos.depositoDTO.DepositoResponseDTO;
import com.example.banco_hex_yoder.encriptacion.EncripcionService;
import com.example.banco_hex_yoder.gateway.AccountGateway;
import com.example.banco_hex_yoder.model.Account;
import com.example.banco_hex_yoder.usecase.depositos.DepositoDesdeCajero;
import com.example.banco_hex_yoder.usecase.depositos.DepositoDesdeOtraCuenta;
import com.example.banco_hex_yoder.usecase.depositos.DepositoDesdeSucursal;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DepositoHandler {

    private final DepositoDesdeSucursal depositoDesdeSucursal;
    private final DepositoDesdeCajero depositoDesdeCajero;
    private final DepositoDesdeOtraCuenta depositoDesdeOtraCuenta;
    private final AccountGateway accountGateway;
    private final EncripcionService encripcionService;

    public DepositoHandler(DepositoDesdeSucursal depositoDesdeSucursal,
                           DepositoDesdeCajero depositoDesdeCajero,
                           DepositoDesdeOtraCuenta depositoDesdeOtraCuenta,
                           AccountGateway accountGateway,
                           EncripcionService encripcionService) {
        this.depositoDesdeSucursal = depositoDesdeSucursal;
        this.depositoDesdeCajero = depositoDesdeCajero;
        this.depositoDesdeOtraCuenta = depositoDesdeOtraCuenta;
        this.accountGateway = accountGateway;
        this.encripcionService = encripcionService;
    }

    public DepositoResponseDTO ejecutarDepositoSucursal(DepositoRequestDTO request) {
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
            Account cuentaDestinoActualizada = depositoDesdeSucursal.realizarDeposito(cuentaOrigenNumber, cuentaDestinoNumber, monto);

            return new DepositoResponseDTO(
                    encripcionService.encriptar(String.valueOf(cuentaDestinoActualizada.getNumber())),
                    cuentaDestinoActualizada.getAmount()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error en el depósito en sucursal: " + e.getMessage(), e);
        }
    }

    public DepositoResponseDTO ejecutarDepositoCajero(DepositoRequestDTO request) {
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
            Account cuentaDestinoActualizada = depositoDesdeCajero.realizarDeposito(cuentaOrigenNumber, cuentaDestinoNumber, monto);

            return new DepositoResponseDTO(
                    encripcionService.encriptar(String.valueOf(cuentaDestinoActualizada.getNumber())),
                    cuentaDestinoActualizada.getAmount()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error en el depósito en cajero: " + e.getMessage(), e);
        }
    }

    public DepositoResponseDTO ejecutarDepositoOtraCuenta(DepositoRequestDTO request) {
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
            Account cuentaDestinoActualizada = depositoDesdeOtraCuenta.realizarDeposito(cuentaOrigenNumber, cuentaDestinoNumber, monto);

            return new DepositoResponseDTO(
                    encripcionService.encriptar(String.valueOf(cuentaDestinoActualizada.getNumber())),
                    cuentaDestinoActualizada.getAmount()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error en el depósito desde otra cuenta: " + e.getMessage(), e);
        }
    }
}
