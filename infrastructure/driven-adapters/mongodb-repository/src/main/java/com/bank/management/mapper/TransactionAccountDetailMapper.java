package com.bank.management.mapper;

import com.bank.management.Transaction;
import com.bank.management.Account;
import com.bank.management.TransactionAccountDetail;
import com.bank.management.data.TransactionAccountDetailDocument;

public class TransactionAccountDetailMapper {

    public static TransactionAccountDetailDocument toDocument(TransactionAccountDetail domain) {
        return new TransactionAccountDetailDocument(domain.getTransaction().getId(), domain.getAccount().getId(), domain.getRole());
    }

}
