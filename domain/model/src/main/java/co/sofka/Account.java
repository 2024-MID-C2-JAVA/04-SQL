package co.sofka;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Account {

    private String id;
    private int number;
    private BigDecimal amount;
    private String customerId;
    private LocalDate createdAt;

    public Account(String id, int number, BigDecimal amount, String clientId, LocalDate createdAt) {
        this.id = id;
        this.number = number;
        this.amount = amount;
        this.customerId = clientId;
        this.createdAt = createdAt;
    }

    public Account() {
    }

    public Account(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
