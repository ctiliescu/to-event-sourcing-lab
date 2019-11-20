package com.ctiliescu.toeventsourcinglab.user.service;

import com.ctiliescu.toeventsourcinglab.exceptions.NotFoundException;
import com.ctiliescu.toeventsourcinglab.user.model.User;
import com.ctiliescu.toeventsourcinglab.user.model.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public CompletableFuture<User> insertUser(User user) {
		return userRepository.insertUser(new UserDb(user));
	}

	@Async
	public CompletableFuture<User> getUser(String userId) {
		return userRepository.getById(userId).thenApply(
				userOp -> userOp.orElseThrow(() -> new NotFoundException("asdsad")));
	}

}
