package co.sofka.usecase.account;

import co.sofka.Account;
import co.sofka.gateway.UpdateRepository;

public class UpdateAccountUseCase {

    private final UpdateRepository<Account>repository;

    public UpdateAccountUseCase(UpdateRepository<Account> repository) {
        this.repository = repository;
    }

    public void apply(Account account) {
        repository.update(account);
    }
}
