package com.bank.management;

import com.bank.management.data.TransactionDocument;
import com.bank.management.mapper.TransactionMapper;
import com.bank.management.gateway.TransactionRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TransactionAdapter implements TransactionRepository {

    private final MongoTemplate mongoTemplate;

    public TransactionAdapter(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Optional<Transaction> save(Transaction trx, Account account, String role) {
        TransactionDocument transactionDocument = TransactionMapper.toDocument(trx);

        TransactionDocument savedDocument = mongoTemplate.save(transactionDocument);

        return Optional.ofNullable(TransactionMapper.toDomain(savedDocument));
    }
}
