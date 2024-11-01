package com.example.banco_hex_yoder.config.usecases;

import com.example.banco_hex_yoder.gateway.AccountGateway;
import com.example.banco_hex_yoder.usecase.compras.CompraEstablecimientoFisico;
import com.example.banco_hex_yoder.usecase.depositos.DepositoDesdeSucursal;
import com.example.banco_hex_yoder.usecase.depositos.DepositoDesdeCajero;
import com.example.banco_hex_yoder.usecase.depositos.DepositoDesdeOtraCuenta;
import com.example.banco_hex_yoder.usecase.compras.CompraPaginaWeb;
import com.example.banco_hex_yoder.usecase.retiros.RetiroEnCajero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class UseCaseConfig {

    @Value("${app.costoDepositoSucursal}")
    private BigDecimal costoDepositoSucursal;

    @Value("${app.costoDepositoCajero}")
    private BigDecimal costoDepositoCajero;

    @Value("${app.costoDepositoOtraCuenta}")
    private BigDecimal costoDepositoOtraCuenta;

    @Value("${app.costoSeguroCompraWeb}")
    private BigDecimal costoSeguroCompraWeb;

    @Value("${app.costoRetiro}")
    private BigDecimal costoRetiro;

    @Value("${app.costoCompraEstablecimiento}")
    private BigDecimal costoCompraEstablecimiento;

    @Bean
    public DepositoDesdeSucursal depositoDesdeSucursal(AccountGateway accountGateway) {
        return new DepositoDesdeSucursal(accountGateway, costoDepositoSucursal);
    }

    @Bean
    public DepositoDesdeCajero depositoDesdeCajero(AccountGateway accountGateway) {
        return new DepositoDesdeCajero(accountGateway, costoDepositoCajero);
    }

    @Bean
    public DepositoDesdeOtraCuenta depositoDesdeOtraCuenta(AccountGateway accountGateway) {
        return new DepositoDesdeOtraCuenta(accountGateway, costoDepositoOtraCuenta);
    }

    @Bean
    public CompraPaginaWeb compraPaginaWeb(AccountGateway accountGateway) {
        return new CompraPaginaWeb(accountGateway, costoSeguroCompraWeb);
    }

    @Bean
    public RetiroEnCajero retiroEnCajero(AccountGateway accountGateway) {
        return new RetiroEnCajero(accountGateway, costoRetiro);
    }

    @Bean
    public CompraEstablecimientoFisico compraEstablecimientoFisico(AccountGateway accountGateway) {
        return new CompraEstablecimientoFisico(accountGateway, costoCompraEstablecimiento);
    }
}
