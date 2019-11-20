package com.ctiliescu.toeventsourcinglab.account.service;

import com.ctiliescu.toeventsourcinglab.account.model.AccountDb;
import com.ctiliescu.toeventsourcinglab.account.model.AccountInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public interface AccountRepository extends MongoRepository<AccountDb, String> {

	@Async
	CompletableFuture<List<AccountDb>> getAByUserId(String userId);

	@Async
	default CompletableFuture<AccountDb> createAccount(String userId,
			AccountInfo accountInfo) {
		return CompletableFuture
				.completedFuture(save(new AccountDb(userId, accountInfo)));
	}

}
