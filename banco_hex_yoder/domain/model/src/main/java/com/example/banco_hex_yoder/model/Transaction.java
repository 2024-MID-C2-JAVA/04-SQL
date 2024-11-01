package com.example.banco_hex_yoder.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "amount_transaction")
    private BigDecimal amountTransaction;

    @Column(name = "transaction_cost")
    private BigDecimal transactionCost;

    @Column(name = "type_transaction")
    private String typeTransaction;

    @Column(name = "time_stamp")
    private LocalDateTime timeStamp;

    @ManyToMany(mappedBy = "transactions", fetch = FetchType.LAZY)
    private List<Account> accounts;

    // Constructor, getters y setters
    public Transaction(Integer id, BigDecimal amountTransaction, BigDecimal transactionCost, String typeTransaction, LocalDateTime timeStamp) {
        this.id = id;
        this.amountTransaction = amountTransaction;
        this.transactionCost = transactionCost;
        this.typeTransaction = typeTransaction;
        this.timeStamp = timeStamp;
    }

    public Transaction() {}

    // Getters y setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public BigDecimal getAmountTransaction() { return amountTransaction; }
    public void setAmountTransaction(BigDecimal amountTransaction) { this.amountTransaction = amountTransaction; }

    public BigDecimal getTransactionCost() { return transactionCost; }
    public void setTransactionCost(BigDecimal transactionCost) { this.transactionCost = transactionCost; }

    public String getTypeTransaction() { return typeTransaction; }
    public void setTypeTransaction(String typeTransaction) { this.typeTransaction = typeTransaction; }

    public LocalDateTime getTimeStamp() { return timeStamp; }
    public void setTimeStamp(LocalDateTime timeStamp) { this.timeStamp = timeStamp; }

    public List<Account> getAccounts() { return accounts; }
    public void setAccounts(List<Account> accounts) { this.accounts = accounts; }
}
