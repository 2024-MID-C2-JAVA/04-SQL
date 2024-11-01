package co.com.sofka.cuentaflex.business.drivenports.repositories;

import co.com.sofka.cuentaflex.business.models.Account;

public interface AccountRepository {
    Account createAccount(Account account);
    Account getByIdAndCustomerId(String accountId, String customerId);
}
