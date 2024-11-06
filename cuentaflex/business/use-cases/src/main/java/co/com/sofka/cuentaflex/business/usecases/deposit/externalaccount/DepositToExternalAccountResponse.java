package co.com.sofka.cuentaflex.business.usecases.deposit.externalaccount;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class DepositToExternalAccountResponse {
    private final String transactionId;
    private final BigDecimal amount;
    private final BigDecimal cost;
    private final LocalDateTime timestamp;
    private final int payrollAccountNumber;
    private final int supplierAccountNumber;

    public DepositToExternalAccountResponse(String transactionId, BigDecimal amount, BigDecimal cost, LocalDateTime timestamp, int payrollAccountNumber, int supplierAccountNumber) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.cost = cost;
        this.timestamp = timestamp;
        this.payrollAccountNumber = payrollAccountNumber;
        this.supplierAccountNumber = supplierAccountNumber;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getPayrollAccountNumber() {
        return payrollAccountNumber;
    }

    public int getSupplierAccountNumber() {
        return supplierAccountNumber;
    }
}
