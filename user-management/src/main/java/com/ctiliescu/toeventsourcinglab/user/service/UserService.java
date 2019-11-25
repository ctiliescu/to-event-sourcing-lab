package com.ctiliescu.toeventsourcinglab.user.service;

import com.ctiliescu.toeventsourcinglab.user.model.User;
import com.ctiliescu.toeventsourcinglab.user.model.UserDb;
import com.ctiliescu.toeventsourcinglab.user.model.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	KafkaTemplate<String, UserEvent> template;

	public CompletableFuture<User> insertUser(User user) {
		return userRepository.insertUser(new UserDb(user)).thenCompose(this::sendUserLog);
	}

	private CompletableFuture<User> sendUserLog(UserDb userDb) {
		return CompletableFuture
				.completedFuture(template.send("user-log",
						new UserEvent(userDb.getId(), "create")))
				.thenApply(res -> userDb);
	}

}
