package com.ctiliescu.toeventsourcinglab.account.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("account")
public class AccountDb extends AccountInfo {
    @Id
    private String id;
    private String userId;
    private int balance;

    public AccountDb() {
    }

    public AccountDb(String userId, AccountInfo accountInfo) {
        this.userId = userId;
        this.setCurrency(accountInfo.getCurrency());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountDb)) return false;
        if (!super.equals(o)) return false;
        AccountDb accountDb = (AccountDb) o;
        return balance == accountDb.balance &&
                Objects.equals(id, accountDb.id) &&
                Objects.equals(userId, accountDb.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, userId, balance);
    }
}
