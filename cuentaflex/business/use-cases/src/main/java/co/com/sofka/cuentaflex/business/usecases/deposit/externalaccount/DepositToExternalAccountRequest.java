package co.com.sofka.cuentaflex.business.usecases.deposit.externalaccount;

import java.math.BigDecimal;

public final class DepositToExternalAccountRequest {
    private final String customerId;
    private final String accountId;
    private final BigDecimal amount;
    private final int accountNumberToDeposit;

    public DepositToExternalAccountRequest(String customerId, String accountId, BigDecimal amount, int accountNumberToDeposit) {
        this.customerId = customerId;
        this.accountId = accountId;
        this.amount = amount;
        this.accountNumberToDeposit = accountNumberToDeposit;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public int getAccountNumberToDeposit() {
        return accountNumberToDeposit;
    }
}
