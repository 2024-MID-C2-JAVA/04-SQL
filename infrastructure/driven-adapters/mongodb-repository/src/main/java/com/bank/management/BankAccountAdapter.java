package com.bank.management;

import com.bank.management.data.AccountDocument;
import com.bank.management.data.CustomerDocument;
import com.bank.management.gateway.AccountRepository;
import com.bank.management.mapper.AccountMapper;
import com.bank.management.mapper.CustomerMapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BankAccountAdapter implements AccountRepository {

    private final MongoTemplate mongoTemplate;

    public BankAccountAdapter(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Optional<Account> findById(String id) {
        AccountDocument document = mongoTemplate.findById(id, AccountDocument.class, "account");
        if (document == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(AccountMapper.toDomain(document));
    }

    @Override
    public boolean delete(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update().set("isDeleted", true);
        return mongoTemplate.updateFirst(query, update, AccountDocument.class).getModifiedCount() > 0;
    }

    @Override
    public Optional<Account> findByNumber(String accountNumber) {
        Query query = new Query(Criteria.where("number").is(accountNumber));
        AccountDocument document = mongoTemplate.findOne(query, AccountDocument.class);
        if (document == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(AccountMapper.toDomain(document));
    }

    @Override
    public List<Account> findByCustomerId(String id) {
        Query query = new Query(Criteria.where("customerId").is(id));
        List<AccountDocument> accountDocuments = mongoTemplate.find(query, AccountDocument.class);

        return accountDocuments.stream()
                .map(AccountMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Account> save(Account account) {
        AccountDocument accountDocument = AccountMapper.toDocument(account);
        AccountDocument savedDocument = mongoTemplate.save(accountDocument);
        Account savedAccount = AccountMapper.toDomain(savedDocument);

        return Optional.of(savedAccount);
    }
}
