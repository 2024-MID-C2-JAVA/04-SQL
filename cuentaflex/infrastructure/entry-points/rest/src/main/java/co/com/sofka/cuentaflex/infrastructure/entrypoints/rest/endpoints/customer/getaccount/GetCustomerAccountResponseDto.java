package co.com.sofka.cuentaflex.infrastructure.entrypoints.rest.endpoints.customer.getaccount;

import java.math.BigDecimal;

public final class GetCustomerAccountResponseDto {
    private String accountId;
    private int number;
    private BigDecimal amount;

    public GetCustomerAccountResponseDto() {
    }

    public GetCustomerAccountResponseDto(String accountId, int number, BigDecimal amount) {
        this.accountId = accountId;
        this.number = number;
        this.amount = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
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
}
