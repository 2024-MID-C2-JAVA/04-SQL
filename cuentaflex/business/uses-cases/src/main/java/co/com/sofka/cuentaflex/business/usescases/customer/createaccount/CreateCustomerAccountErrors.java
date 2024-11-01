package co.com.sofka.cuentaflex.business.usescases.customer.createaccount;

import co.com.sofka.shared.business.usescases.Error;

public final class CreateCustomerAccountErrors {
    public static final Error CUSTOMER_NOT_FOUND = new Error(
            "CUSTOMER_NOT_FOUND",
            "Customer not found"
    );
}
