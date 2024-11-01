package co.sofka.data.account;

import co.sofka.data.customer.CreateCustomerDTO;
import co.sofka.enums.TypeOfTransaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountUpdateDTO {

    private String id;
    private int number;
    private BigDecimal amount;
    private String customerId;
    private LocalDate createdAt;
    private CreateCustomerDTO createCustomer;

    public AccountUpdateDTO(String id, int number, BigDecimal amount, String customerId, LocalDate createdAt) {
        this.id = id;
        this.number = number;
        this.amount = amount;
        this.customerId = customerId;
        this.createdAt = createdAt;
    }

    public AccountUpdateDTO() {
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

    public CreateCustomerDTO getCreateCustomer() {
        return createCustomer;
    }
}
