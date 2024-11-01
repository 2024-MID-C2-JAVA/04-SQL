package com.example.banco_hex_yoder.handlers.depositos;

import com.example.banco_hex_yoder.model.Account;
import com.example.banco_hex_yoder.usecase.depositos.DepositoDesdeSucursal;
import com.example.banco_hex_yoder.usecase.depositos.DepositoDesdeCajero;
import com.example.banco_hex_yoder.usecase.depositos.DepositoDesdeOtraCuenta;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DepositoHandler {

    private final DepositoDesdeSucursal depositoDesdeSucursal;
    private final DepositoDesdeCajero depositoDesdeCajero;
    private final DepositoDesdeOtraCuenta depositoDesdeOtraCuenta;

    public DepositoHandler(DepositoDesdeSucursal depositoDesdeSucursal,
                           DepositoDesdeCajero depositoDesdeCajero,
                           DepositoDesdeOtraCuenta depositoDesdeOtraCuenta) {
        this.depositoDesdeSucursal = depositoDesdeSucursal;
        this.depositoDesdeCajero = depositoDesdeCajero;
        this.depositoDesdeOtraCuenta = depositoDesdeOtraCuenta;
    }

    public Account ejecutarDepositoSucursal(Integer cuentaOrigenNumber, Integer cuentaDestinoNumber, BigDecimal monto) {
        return depositoDesdeSucursal.realizarDeposito(cuentaOrigenNumber, cuentaDestinoNumber, monto);
    }

    public Account ejecutarDepositoCajero(Integer cuentaOrigenNumber, Integer cuentaDestinoNumber, BigDecimal monto) {
        return depositoDesdeCajero.realizarDeposito(cuentaOrigenNumber, cuentaDestinoNumber, monto);
    }

    public Account ejecutarDepositoOtraCuenta(Integer cuentaOrigenNumber, Integer cuentaDestinoNumber, BigDecimal monto) {
        return depositoDesdeOtraCuenta.realizarDeposito(cuentaOrigenNumber, cuentaDestinoNumber, monto);
    }
}
