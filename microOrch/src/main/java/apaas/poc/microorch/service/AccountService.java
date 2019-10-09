package apaas.poc.microorch.service;

import apaas.poc.microorch.service.dto.AccountDTO;

public interface AccountService {

	public AccountDTO updateAccount(AccountDTO account);

	public boolean checkAccount(AccountDTO accountDTO);

}
