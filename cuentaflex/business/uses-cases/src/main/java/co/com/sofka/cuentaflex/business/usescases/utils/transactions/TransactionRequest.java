package co.com.sofka.cuentaflex.business.usescases.utils.transactions;

import java.math.BigDecimal;

public class TransactionRequest {
    private final String payrollAccountNumber;
    private final String supplierAccountNumber;
    private final BigDecimal amount;

    public TransactionRequest(String payrollAccountNumber, String supplierAccountNumber, BigDecimal amount) {
        this.payrollAccountNumber = payrollAccountNumber;
        this.supplierAccountNumber = supplierAccountNumber;
        this.amount = amount;
    }
}
