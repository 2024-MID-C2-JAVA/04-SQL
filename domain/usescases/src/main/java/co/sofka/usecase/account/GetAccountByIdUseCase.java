package co.sofka.usecase.account;

import co.sofka.Account;
import co.sofka.gateway.GetByIdRepository;

public class GetAccountByIdUseCase {
    private final GetByIdRepository<Account>repository;

    public GetAccountByIdUseCase(GetByIdRepository<Account> repository) {
        this.repository = repository;
    }

    public Account apply(Account account) {
        return repository.getById(account);
    }
}
