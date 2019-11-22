package com.ctiliescu.toeventsourcinglab.user;

import com.ctiliescu.toeventsourcinglab.user.model.User;
import com.ctiliescu.toeventsourcinglab.user.model.UserDb;
import com.ctiliescu.toeventsourcinglab.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	CompletableFuture<User> insertUser(@RequestBody User user) {
		return userService.insertUser(user);
	}

	@GetMapping("/{userId}")
	@ResponseStatus(HttpStatus.CREATED)
	CompletableFuture<UserDb> getUser(@PathVariable String userId) {
		return userService.getUser(userId);
	}

}
