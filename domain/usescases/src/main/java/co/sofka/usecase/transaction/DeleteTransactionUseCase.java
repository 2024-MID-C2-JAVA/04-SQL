package co.sofka.usecase.transaction;

import co.sofka.Transaction;
import co.sofka.gateway.DeleteRepository;

public class DeleteTransactionUseCase {

    private final DeleteRepository<Transaction> repository;


    public DeleteTransactionUseCase(DeleteRepository<Transaction> repository) {
        this.repository = repository;
    }

    public void deleteTransaction(Transaction transaction) {
        repository.delete(transaction);
    }
}
