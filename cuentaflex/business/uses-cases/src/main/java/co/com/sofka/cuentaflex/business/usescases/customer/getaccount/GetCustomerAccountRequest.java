package co.com.sofka.cuentaflex.business.usescases.customer.getaccount;

public class GetCustomerAccountRequest {
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
