package com.ctiliescu.toeventsourcinglab.account.service;

import com.ctiliescu.toeventsourcinglab.account.model.AccountInfo;
import com.ctiliescu.toeventsourcinglab.account.model.exceptions.NotFoundException;
import com.ctiliescu.toeventsourcinglab.user.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserRepository userRepository;

	public CompletableFuture<AccountInfo> createAccount(AccountInfo accountInfo,
			String userId) {
		return CompletableFuture.completedFuture(userRepository.getByUserId(userId))
				.thenCompose(user -> accountRepository.createAccount(userId, accountInfo))
				.thenApply(a -> a);
	}

	public CompletableFuture<List<AccountInfo>> getUserAccounts(String userId) {
		return accountRepository.getAByUserId(userId).thenApply(
				list -> list.stream().map(a -> a).collect(Collectors.toList()));
	}

	public CompletableFuture<AccountInfo> getAccount(String accountId) {
		return CompletableFuture.completedFuture(accountRepository.findById(accountId))
				.thenApply(accountOp -> accountOp
						.orElseThrow(() -> new NotFoundException("asdsad")));
	}

}
