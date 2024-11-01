package com.example.banco_hex_yoder.postgresql_repository.data.entidades;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TransactionAccountDetailId implements Serializable {

    private Integer transactionId;
    private Integer accountId;

    // Constructor vacío
    public TransactionAccountDetailId() {}

    // Constructor con argumentos
    public TransactionAccountDetailId(Integer transactionId, Integer accountId) {
        this.transactionId = transactionId;
        this.accountId = accountId;
    }

    // Getters y Setters
    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    // hashCode y equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionAccountDetailId that = (TransactionAccountDetailId) o;
        return Objects.equals(transactionId, that.transactionId) && Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, accountId);
    }
}
