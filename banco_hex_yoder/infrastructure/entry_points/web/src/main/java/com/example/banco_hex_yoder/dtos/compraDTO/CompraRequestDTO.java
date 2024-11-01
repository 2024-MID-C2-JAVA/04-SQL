package com.example.banco_hex_yoder.dtos.compraDTO;

import java.math.BigDecimal;

public class CompraRequestDTO {
    private String cuentaOrigen;
    private BigDecimal monto;

    public CompraRequestDTO() {}

    public CompraRequestDTO(String cuentaOrigen, BigDecimal monto) {
        this.cuentaOrigen = cuentaOrigen;
        this.monto = monto;
    }

    public String getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}
