package co.sofka.adapters;

import co.sofka.Account;
import co.sofka.data.AccountDocument;
import co.sofka.exception.NotFoundException;
import co.sofka.gateway.CreateRepository;
import co.sofka.gateway.DeleteRepository;
import co.sofka.gateway.GetByIdRepository;
import co.sofka.gateway.UpdateRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public class MongoAccountAdapter implements CreateRepository<Account>, DeleteRepository<Account>, GetByIdRepository<Account> {

    private final MongoTemplate mongoTemplate;

    public MongoAccountAdapter(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void create(Account account) {
        AccountDocument accountDocument = new AccountDocument();
        accountDocument.setNumber(account.getNumber());
        accountDocument.setAmount(account.getAmount());
        accountDocument.setCustomerId(account.getCustomerId());
        accountDocument.setCreatedAt(LocalDate.now());
        accountDocument.setDeleted(false);
        mongoTemplate.save(accountDocument);
    }


    @Override
    public void delete(Account account) {
        AccountDocument accountDocument = mongoTemplate.findById(account.getId(), AccountDocument.class);
        assert accountDocument != null;
        accountDocument.setDeleted(true);
        mongoTemplate.save(accountDocument);
    }


    @Override
    public Account getById(Account account) {
        Optional<AccountDocument>accountDocument= Optional.ofNullable(mongoTemplate.findById(account.getId(), AccountDocument.class));

        if(accountDocument.isEmpty()) {
            throw new NotFoundException("Account does not exist");
        }

        return new Account(accountDocument.get().getId(),
                accountDocument.get().getNumber(),
                accountDocument.get().getAmount(),
                accountDocument.get().getCustomerId(),
                accountDocument.get().getCreatedAt());
    }
}
