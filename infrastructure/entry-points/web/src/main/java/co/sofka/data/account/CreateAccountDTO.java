package co.sofka.data.account;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreateAccountDTO {

    private int number;
    private BigDecimal amount;
    private String customerId;

    public CreateAccountDTO(int number, BigDecimal amount, String customerId, LocalDate createdAt) {
        this.number = number;
        this.amount = amount;
        this.customerId = customerId;
    }

    public CreateAccountDTO() {
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
}
