package com.ctiliescu.toeventsourcinglab.account.service;

import com.ctiliescu.toeventsourcinglab.account.model.AccountDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public interface AccountRepository extends MongoRepository<AccountDb, String> {
    CompletableFuture<List<AccountDb>> getAByUserId(String userId);
}
