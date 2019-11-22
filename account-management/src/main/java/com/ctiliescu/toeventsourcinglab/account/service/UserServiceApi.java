package com.ctiliescu.toeventsourcinglab.account.service;

import com.ctiliescu.toeventsourcinglab.account.config.FeignConfig;
import com.ctiliescu.toeventsourcinglab.account.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UserMicroService", url = "localhost:9009/api/v1/users", configuration = FeignConfig.class)
public interface UserServiceApi {

	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") String userId);

}
