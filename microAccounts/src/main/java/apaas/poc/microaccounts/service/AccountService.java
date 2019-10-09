package apaas.poc.microaccounts.service;

import java.util.List;

import apaas.poc.microaccounts.controller.dto.AccountDTO;

public interface AccountService {

	List<AccountDTO> retrieveAll();

	AccountDTO retrieveAccount(String accountId);

	AccountDTO addAccount(AccountDTO account);

	AccountDTO updateAccount(AccountDTO account);

	boolean deleteAccount(String accountId);

}
