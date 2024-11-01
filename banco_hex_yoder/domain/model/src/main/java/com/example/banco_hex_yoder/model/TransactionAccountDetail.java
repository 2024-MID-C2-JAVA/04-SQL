package com.example.banco_hex_yoder.model;

import com.example.banco_hex_yoder.compositekeys.TransactionAccountDetailId;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transaction_account_detail")
public class TransactionAccountDetail implements Serializable {

    @EmbeddedId
    private TransactionAccountDetailId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("transactionId")
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("accountId")
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "transaction_role")
    private String transactionRole;

    // Getters y setters
    public TransactionAccountDetailId getId() { return id; }
    public void setId(TransactionAccountDetailId id) { this.id = id; }

    public Transaction getTransaction() { return transaction; }
    public void setTransaction(Transaction transaction) { this.transaction = transaction; }

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }

    public String getTransactionRole() { return transactionRole; }
    public void setTransactionRole(String transactionRole) { this.transactionRole = transactionRole; }
}
