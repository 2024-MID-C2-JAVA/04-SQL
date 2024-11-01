package com.example.banco_hex_yoder.handlers.retiros;

import com.example.banco_hex_yoder.model.Account;
import com.example.banco_hex_yoder.usecase.retiros.RetiroEnCajero;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RetiroHandler {

    private final RetiroEnCajero retiroCajero;

    public RetiroHandler(RetiroEnCajero retiroCajero) {
        this.retiroCajero = retiroCajero;
    }

    public Account ejecutarRetiroCajero(Integer cuentaOrigenNumber, Integer cuentaDestinoNumber, BigDecimal monto) {
        return retiroCajero.realizarRetiro(cuentaOrigenNumber, cuentaDestinoNumber, monto);
    }
}
