package co.com.sofka.cuentaflex.business.models;

import co.com.sofka.shared.business.models.BaseAuditableModel;
import co.com.sofka.shared.business.models.SoftDeletable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public final class Account extends BaseAuditableModel implements SoftDeletable {
    private int number;
    private BigDecimal amount;
    private String customerId;
    private boolean isDeleted;
    private AccountMovementsHistory transactionHistory;

    public Account(String id, int number, BigDecimal amount, String customerId, boolean isDeleted) {
        super(id);
        this.number = number;
        this.amount = amount;
        this.customerId = customerId;
        this.isDeleted = isDeleted;
    }

    public Account(String id, int number, BigDecimal amount, String customerId) {
        super(id);
        this.number = number;
        this.amount = amount;
        this.customerId = customerId;
        this.isDeleted = false;
    }

    public Account(String id, LocalDateTime createdAt, int number, BigDecimal amount, String customerId, boolean isDeleted) {
        super(id, createdAt);
        this.number = number;
        this.amount = amount;
        this.customerId = customerId;
        this.isDeleted = isDeleted;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean isDeleted() {
        return this.isDeleted;
    }

    @Override
    public void setDeleted(boolean deleted) {
        this.isDeleted = deleted;
    }
}
