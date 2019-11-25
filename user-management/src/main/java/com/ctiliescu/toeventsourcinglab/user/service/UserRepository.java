package com.ctiliescu.toeventsourcinglab.user.service;

import com.ctiliescu.toeventsourcinglab.user.model.UserDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;

@Repository
public interface UserRepository extends MongoRepository<UserDb, String> {

	default CompletableFuture<UserDb> insertUser(UserDb userDb) {
		return CompletableFuture.completedFuture(save(userDb));
	}

}
