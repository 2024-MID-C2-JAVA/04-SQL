package co.com.sofka.cuentaflex.business.usescases.customer.create;

public final class CreateCustomerRequest {
    private final String username;

    public CreateCustomerRequest(String userName) {
        this.username = userName;
    }

    public String getUsername() {
        return username;
    }
}
