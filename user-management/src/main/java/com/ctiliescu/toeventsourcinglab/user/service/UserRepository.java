package com.ctiliescu.toeventsourcinglab.user.service;

import com.ctiliescu.toeventsourcinglab.user.model.User;
import com.ctiliescu.toeventsourcinglab.user.model.UserDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Repository
public interface UserRepository extends MongoRepository<UserDb, String> {

	default CompletableFuture<User> insertUser(UserDb userDb) {
		return CompletableFuture.completedFuture(save(userDb)).thenApply(u -> u);
	}

	CompletableFuture<Optional<UserDb>> getById(String id);

}
