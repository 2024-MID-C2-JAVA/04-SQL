package co.sofka.usecase.transaction;

import co.sofka.Transaction;
import co.sofka.gateway.GetByIdRepository;

public class GetTransactionByIdUseCase {

    private final GetByIdRepository<Transaction> repository;

    public GetTransactionByIdUseCase(GetByIdRepository<Transaction> repository) {
        this.repository = repository;
    }

    public Transaction apply(Transaction transaction) {
        return repository.getById(transaction);
    }
}
