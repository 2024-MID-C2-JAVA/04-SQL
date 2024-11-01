package co.com.sofka.cuentaflex.business.usescases.customer.createaccount;

import java.math.BigDecimal;

public final class CreateCustomerAccountRequest {
    private final String customerId;
    private final BigDecimal amount;

    public CreateCustomerAccountRequest(String customerId, BigDecimal amount) {
        this.customerId = customerId;
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
