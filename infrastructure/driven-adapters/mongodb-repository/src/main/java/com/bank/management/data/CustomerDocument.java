package com.bank.management.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document(collection = "customer")
public class CustomerDocument {

    @Id
    private String id;

    private String username;


    @Field("account_ids")
    private List<String> accountIds;

    @Field("created_at")
    private Date createdAt;

    @Field("is_deleted")
    private boolean isDeleted;

    public CustomerDocument() {}

    public CustomerDocument(String username, List<String> accountIds) {
        this.username = username;
        this.accountIds = accountIds;
        this.createdAt = new Date();
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
