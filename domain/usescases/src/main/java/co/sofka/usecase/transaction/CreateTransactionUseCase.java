package co.sofka.usecase.transaction;

import co.sofka.Transaction;
import co.sofka.exceptions.InvalidCreationException;
import co.sofka.gateway.CreateRepository;
import co.sofka.usecase.strategy.AccountMovementContext;

public class CreateTransactionUseCase {

    private final CreateRepository<Transaction>repository;


    public CreateTransactionUseCase(CreateRepository<Transaction> repository) {
        this.repository = repository;
    }

    public void apply(Transaction transaction) {

        if(transaction == null){
            throw new InvalidCreationException("Transaction cannot be null");
        }

        Transaction transaction1=AccountMovementContext.accountMovement(transaction).movement(transaction);
        repository.create(transaction1);
    }

}
