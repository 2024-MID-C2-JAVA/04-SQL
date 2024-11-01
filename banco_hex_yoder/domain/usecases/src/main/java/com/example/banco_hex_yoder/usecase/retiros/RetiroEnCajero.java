package com.example.banco_hex_yoder.usecase.retiros;

import com.example.banco_hex_yoder.model.Account;
import com.example.banco_hex_yoder.gateway.AccountGateway;
import java.math.BigDecimal;

public class RetiroEnCajero {

    private final AccountGateway accountGateway;
    private final BigDecimal costoRetiro;

    public RetiroEnCajero(AccountGateway accountGateway, BigDecimal costoRetiro) {
        this.accountGateway = accountGateway;
        this.costoRetiro = costoRetiro;
    }

    public Account realizarRetiro(Integer cuentaOrigenNumber, Integer cuentaDestinoNumber, BigDecimal monto) {
        Account cuentaOrigen = accountGateway.findByNumber(cuentaOrigenNumber)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta origen no encontrada"));

        BigDecimal montoTotal = monto.add(costoRetiro);

        if (cuentaOrigen.getAmount().compareTo(montoTotal) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar el retiro");
        }

        // Debitar el monto total de la cuenta origen (incluido el costo de retiro)
        cuentaOrigen.setAmount(cuentaOrigen.getAmount().subtract(montoTotal));

        // Guardar la cuenta actualizada
        accountGateway.save(cuentaOrigen);

        // Registrar la transacción
        accountGateway.registrarTransaccion(monto, costoRetiro, "RetiroCajero", cuentaOrigenNumber, cuentaDestinoNumber);

        return cuentaOrigen;
    }
}
