package com.ctiliescu.toeventsourcinglab.user.service;

import com.ctiliescu.toeventsourcinglab.user.model.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserKafkaService {

	@Autowired
	private UserRepository userRepository;

	@KafkaListener(topics = "user-log", containerFactory = "kafkaListenerContainerFactory")
	public void userEventListener(UserEvent userEvent) {
		userRepository.createUser(userEvent.getId());
	}

}
