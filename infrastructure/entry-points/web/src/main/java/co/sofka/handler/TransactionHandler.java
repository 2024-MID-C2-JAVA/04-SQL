package co.sofka.handler;

import co.sofka.Transaction;
import co.sofka.data.transaction.CreateTransactionDTO;
import co.sofka.data.transaction.GetTransactionDTO;
import co.sofka.data.transaction.TransactionResponseDTO;
import co.sofka.enums.Role;
import co.sofka.usecase.transaction.CreateTransactionUseCase;
import co.sofka.usecase.transaction.GetTransactionByIdUseCase;
import org.springframework.stereotype.Component;

@Component
public class TransactionHandler {

    private final CreateTransactionUseCase transactionUseCase;
    private final GetTransactionByIdUseCase transactionByIdUseCase;

    public TransactionHandler(CreateTransactionUseCase transactionUseCase, GetTransactionByIdUseCase transactionByIdUseCase) {
        this.transactionUseCase = transactionUseCase;
        this.transactionByIdUseCase = transactionByIdUseCase;
    }

    public void createTransaction(CreateTransactionDTO transactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setType(transactionDTO.getType());
        transaction.setAccountId(transactionDTO.getAccountId());
        transactionUseCase.apply(transaction);
    }


    public TransactionResponseDTO getTransactionById(GetTransactionDTO getTransactionDTO){
        Transaction transaction= transactionByIdUseCase.apply(new Transaction(getTransactionDTO.getId()));
        return new TransactionResponseDTO(
                transaction.getId(),
                transaction.getAmount(),
                transaction.getAmountCost(),
                transaction.getType(),
                transaction.getTimeStamp()
        );
    }
}


