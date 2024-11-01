package co.com.sofka.cuentaflex.business.usescases.customer.getaccount;

import java.math.BigDecimal;

public class GetCustomerAccountResponse {
    private final String accountId;
    private final int number;
    private final BigDecimal amount;

    public GetCustomerAccountResponse(String accountId, int number, BigDecimal amount) {
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
