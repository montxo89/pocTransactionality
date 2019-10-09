package apaas.poc.microaccounts.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apaas.poc.microaccounts.controller.dto.AccountDTO;
import apaas.poc.microaccounts.data.model.Account;
import apaas.poc.microaccounts.data.repository.AccountRepositoryService;
import apaas.poc.microaccounts.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	static Logger logger = Logger.getLogger(AccountServiceImpl.class.getName());

	@Autowired
	private AccountRepositoryService repository;

	@Override
	public List<AccountDTO> retrieveAll() {

		logger.info("MicroAccounts AccountServiceImpl retrieveAll entered");

		List<Account> accounts = repository.listAllAccounts();
		List<AccountDTO> accountDTOs = new ArrayList<>();

		for (Account account : accounts) {
			accountDTOs.add(mappFromAccountToAccountDTO(account));
		}

		return accountDTOs;
	}

	@Override
	public AccountDTO retrieveAccount(String clientId) {
		Account account = repository.showAccountById(clientId);
		return mappFromAccountToAccountDTO(account);

	}

	@Override
	public AccountDTO addAccount(AccountDTO accountDto) {

		logger.info("MicroAccounts AccountServiceImpl addAccount entered");
		long unixTime = System.currentTimeMillis() / 1000L;
		Account account = mappFromAccountDTOToAccount(accountDto);
		account.setAccountNumber(String.valueOf(unixTime));
		return mappFromAccountToAccountDTO(repository.insertAccount(account));

	}

	@Override
	public AccountDTO updateAccount(AccountDTO account) {
		return mappFromAccountToAccountDTO(repository.modifyAccount(mappFromAccountDTOToAccount(account)));
	}

	@Override
	public boolean deleteAccount(String accountId) {
		return repository.deleteAccount(accountId);
	}

	private Account mappFromAccountDTOToAccount(AccountDTO accountDto) {

		Account account = new Account();
		account.setUserId(accountDto.getClientId());
		account.setBalance(accountDto.getBalance());

		return account;
	}

	private AccountDTO mappFromAccountToAccountDTO(Account account) {

		AccountDTO accountDto = new AccountDTO();
		accountDto.setClientId(account.getUserId());
		accountDto.setBalance(account.getBalance());

		return accountDto;
	}

}
