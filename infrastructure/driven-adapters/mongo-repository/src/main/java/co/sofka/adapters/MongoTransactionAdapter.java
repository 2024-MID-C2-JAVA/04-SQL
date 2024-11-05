package co.sofka.adapters;

import co.sofka.Transaction;
import co.sofka.data.TransactionDocument;
import co.sofka.exception.NotFoundException;
import co.sofka.gateway.CreateRepository;
import co.sofka.gateway.GetByIdRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Repository
public class MongoTransactionAdapter implements CreateRepository<Transaction>, GetByIdRepository<Transaction> {

    private final MongoTemplate mongoTemplate;

    public MongoTransactionAdapter(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void create(Transaction transaction) {
        TransactionDocument transactionDocument = new TransactionDocument();
        transactionDocument.setAmount(transaction.getAmount());
        transactionDocument.setAmountCost(transaction.getAmountCost());
        transactionDocument.setTypeOfTransaction(transaction.getType());
        mongoTemplate.save(transactionDocument);
    }

    @Override
    public Transaction getById(Transaction transaction) {

        Optional<TransactionDocument> transactionDocument = Optional.ofNullable(mongoTemplate.findById(transaction.getId(), TransactionDocument.class));

        if (transactionDocument.isEmpty()) {
            throw new NotFoundException("Transaction does not exist");
        }

        ZoneOffset zoneOffset = ZoneOffset.UTC;
        OffsetDateTime offsetDateTime = transactionDocument.get().getTimeStamp().atOffset(zoneOffset);
        return new Transaction(
                transactionDocument.get().getId(),
                transactionDocument.get().getAmount(),
                transactionDocument.get().getAmountCost(),
                transactionDocument.get().getTypeOfTransaction(),
                offsetDateTime
        );

    }
}
