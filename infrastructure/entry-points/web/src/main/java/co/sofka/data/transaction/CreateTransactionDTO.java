package co.sofka.data.transaction;

import co.sofka.enums.TypeOfTransaction;

import java.math.BigDecimal;

public class CreateTransactionDTO {

    private BigDecimal amount;
    private TypeOfTransaction type;
    private String accountId;

    public CreateTransactionDTO(BigDecimal amount, TypeOfTransaction type) {
        this.amount = amount;
        this.type = type;
    }

    public CreateTransactionDTO(BigDecimal amount, TypeOfTransaction type, String accountId) {
        this.amount = amount;
        this.type = type;
        this.accountId = accountId;
    }

    public CreateTransactionDTO() {
    }

    public TypeOfTransaction getType() {
        return type;
    }

    public void setType(TypeOfTransaction type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

}
