package co.sofka.usecase.account;

import co.sofka.Account;
import co.sofka.gateway.DeleteRepository;

public class DeleteAccountUseCase {

    private final DeleteRepository<Account>repository;

    public DeleteAccountUseCase(DeleteRepository<Account> repository) {
        this.repository = repository;
    }

    public void apply(Account account) {
        repository.delete(account);
    }
}
