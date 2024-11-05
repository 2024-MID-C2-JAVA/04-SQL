package com.bank.management.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "transaction_account_detail")
public class TransactionAccountDetailDocument {

    @Id
    private String id;

    @Field("transaction_id")
    private String transactionId;

    @Field("account_id")
    private String accountId;

    @Field("role")
    private String role; // Ej: "SENDER" o "RECEIVER"

    public TransactionAccountDetailDocument() {}

    public TransactionAccountDetailDocument(String transactionId, String accountId, String role, String id) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.role = role;
        this.id = id;
    }

    public TransactionAccountDetailDocument(String transactionId, String accountId, String role) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.role = role;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
