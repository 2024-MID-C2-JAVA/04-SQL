package co.com.sofka.cuentaflex.infrastructure.entrypoints.rest.endpoints.deposit.externalaccount;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class DepositToExternalAccountResponseDto {
    private String transactionId;
    private BigDecimal amount;
    private BigDecimal cost;
    private LocalDateTime timestamp;
    private int payrollAccountNumber;
    private int supplierAccountNumber;

    public DepositToExternalAccountResponseDto() {
    }

    public DepositToExternalAccountResponseDto(String transactionId, BigDecimal amount, BigDecimal cost, LocalDateTime timestamp, int payrollAccountNumber, int supplierAccountNumber) {
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

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getPayrollAccountNumber() {
        return payrollAccountNumber;
    }

    public void setPayrollAccountNumber(int payrollAccountNumber) {
        this.payrollAccountNumber = payrollAccountNumber;
    }

    public int getSupplierAccountNumber() {
        return supplierAccountNumber;
    }

    public void setSupplierAccountNumber(int supplierAccountNumber) {
        this.supplierAccountNumber = supplierAccountNumber;
    }
}
