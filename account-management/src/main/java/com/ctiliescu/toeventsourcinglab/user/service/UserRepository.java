package com.ctiliescu.toeventsourcinglab.user.service;

import com.ctiliescu.toeventsourcinglab.account.model.AccountDb;
import com.ctiliescu.toeventsourcinglab.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	@Async
	CompletableFuture<List<AccountDb>> getByUserId(String userId);

	@Async
	default CompletableFuture<User> createUser(String userId) {
		return CompletableFuture.completedFuture(save(new User(userId)));
	}

}
