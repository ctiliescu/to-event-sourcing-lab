package com.ctiliescu.toeventsourcinglab.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.ctiliescu.toeventsourcinglab.account.model.AccountInfo;
import com.ctiliescu.toeventsourcinglab.account.service.AccountService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/v1/accounts", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	CompletableFuture<AccountInfo> createAccount(@RequestParam String userId,
			@RequestBody AccountInfo accountInfo) {
		return accountService.createAccount(accountInfo, userId);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	CompletableFuture<List<AccountInfo>> getAllAccounts(@RequestParam String userId) {
		return accountService.getUserAccounts(userId);
	}

	@GetMapping("/{accountId}")
	@ResponseStatus(HttpStatus.OK)
	CompletableFuture<List<AccountInfo>> getAllAccounts(@PathVariable String accountId,
			@RequestParam String userId) {
		return accountService.getUserAccounts(userId);
	}

}
