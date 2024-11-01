package com.example.banco_hex_yoder.handlers.compras;

import com.example.banco_hex_yoder.model.Account;
import com.example.banco_hex_yoder.usecase.compras.CompraEstablecimientoFisico;
import com.example.banco_hex_yoder.usecase.compras.CompraPaginaWeb;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CompraHandler {

    private final CompraEstablecimientoFisico compraFisico;
    private final CompraPaginaWeb compraWeb;

    public CompraHandler(CompraEstablecimientoFisico compraFisico, CompraPaginaWeb compraWeb) {
        this.compraFisico = compraFisico;
        this.compraWeb = compraWeb;
    }

    public Account ejecutarCompraFisico(Integer cuentaOrigenNumber, BigDecimal monto) {
        return compraFisico.realizarCompra(cuentaOrigenNumber, monto);
    }

    public Account ejecutarCompraWeb(Integer cuentaOrigenNumber, BigDecimal monto) {
        return compraWeb.realizarCompra(cuentaOrigenNumber, monto);
    }
}
