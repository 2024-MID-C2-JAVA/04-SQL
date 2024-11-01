package co.com.sofka.cuentaflex.business.usescases.customer.getaccount;

import co.com.sofka.shared.business.usescases.Error;

public final class GetCustomerAccountErrors {
    public static final Error ACCOUNT_NOT_FOUND = new Error(
            "ACCOUNT_NOT_FOUND",
            "The account was not found"
    );
}
