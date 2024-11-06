package co.com.sofka.cuentaflex.business.usecases.customer.getaccount;

public final class GetCustomerAccountRequest {
    private final String customerId;
    private final String accountId;

    public GetCustomerAccountRequest(String customerId, String accountId) {
        this.customerId = customerId;
        this.accountId = accountId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getAccountId() {
        return accountId;
    }
}
