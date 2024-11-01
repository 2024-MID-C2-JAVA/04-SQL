package co.com.sofka.cuentaflex.business.usescases.customer.createaccount;

import java.math.BigDecimal;

public final class CreateCustomerAccountResponse {
    private final String accountId;
    private final int number;
    private final BigDecimal amount;

    public CreateCustomerAccountResponse(String accountId, int number, BigDecimal amount) {
        this.accountId = accountId;
        this.number = number;
        this.amount = amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public int getNumber() {
        return number;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
