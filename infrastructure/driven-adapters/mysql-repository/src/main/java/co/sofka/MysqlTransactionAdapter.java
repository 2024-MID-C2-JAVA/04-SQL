package co.sofka;

import co.sofka.config.MysqlAccountRepository;
import co.sofka.config.MysqlAccountTransactionRepository;
import co.sofka.config.MysqlTransactionRepository;
import co.sofka.data.AccountEntity;
import co.sofka.data.AccountTransactionEntity;
import co.sofka.data.TransactionEntity;
import co.sofka.exception.InvalidAmountException;
import co.sofka.exception.TransactionNotFoundException;
import co.sofka.gateway.CreateRepository;
import co.sofka.gateway.DeleteRepository;
import co.sofka.gateway.GetByIdRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public class MysqlTransactionAdapter implements CreateRepository<Transaction>, DeleteRepository<Transaction>, GetByIdRepository<Transaction> {

    private final MysqlTransactionRepository repository;
    private final MysqlAccountRepository accountRepository;
    private final MysqlAccountTransactionRepository accountTransactionRepository;

    public MysqlTransactionAdapter(MysqlTransactionRepository transactionRepository, MysqlAccountRepository accountRepository, MysqlAccountTransactionRepository accountTransactionRepository) {
        this.repository = transactionRepository;
        this.accountRepository = accountRepository;
        this.accountTransactionRepository = accountTransactionRepository;
    }

    @Override
    @Transactional
    public void create(Transaction transaction) {

        TransactionEntity transactionEntity = new TransactionEntity();
        if(transaction.getAmount().compareTo(BigDecimal.ZERO) < 0 ){
            throw new InvalidAmountException("The amount can´t be negative");
        }
        transactionEntity.setAmount(transaction.getAmount());
        transactionEntity.setAmountCost(transaction.getAmountCost());
        transactionEntity.setType(transaction.getType());

        AccountEntity accountEntity = accountRepository.findById(Integer.parseInt(transaction.getAccountId())).get();

        AccountTransactionEntity accountTransaction = new AccountTransactionEntity();
        accountTransaction.setAccount(accountEntity);
        accountTransaction.setTransaction(transactionEntity);


        accountEntity.addTransaction(accountTransaction);
        transactionEntity.addAccount(accountTransaction);

        repository.save(transactionEntity);
        accountTransactionRepository.save(accountTransaction);
    }

    @Override
    public void delete(Transaction transaction) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setId(Integer.parseInt(transaction.getId()));
        repository.delete(transactionEntity);
    }

    @Override
    public Transaction getById(Transaction transaction) {
            Optional<TransactionEntity> transactionEntityOpt = repository.findById(Integer.parseInt(transaction.getId()));
            if(transactionEntityOpt.isEmpty()){
                throw new TransactionNotFoundException("The transaction does not exist");
            }else{
                TransactionEntity transactionEntity = transactionEntityOpt.get();
                return new Transaction(String.valueOf(transactionEntity.getId()),transactionEntity.getAmount(),transactionEntity.getAmountCost(),transactionEntity.getType(),transactionEntity.getTimestamp());
            }
    }

}
