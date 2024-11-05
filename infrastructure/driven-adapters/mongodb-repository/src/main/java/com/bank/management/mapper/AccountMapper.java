package com.bank.management.mapper;

import com.bank.management.Account;
import com.bank.management.data.AccountDocument;
import com.bank.management.Customer;

public class AccountMapper {

    public static AccountDocument toDocument(Account account) {
        AccountDocument document = new AccountDocument();
        document.setId(account.getId());
        document.setNumber(account.getNumber());
        document.setAmount(account.getAmount());
        document.setCustomerId(account.getCustomer() != null ? account.getCustomer().getId() : null);
        document.setDeleted(account.isDeleted());
        document.setCreatedAt(account.getCreated_at());
        return document;
    }

    public static Account toDomain(AccountDocument document) {
        return new Account.Builder()
                .id(document.getId())
                .number(document.getNumber())
                .amount(document.getAmount())
                .isDeleted(document.isDeleted())
                .createdAt(document.getCreatedAt())
                .build();
    }
}
