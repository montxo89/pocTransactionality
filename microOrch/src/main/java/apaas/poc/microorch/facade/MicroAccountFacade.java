package apaas.poc.microorch.facade;

import apaas.poc.microorch.service.dto.AccountDTO;

public interface MicroAccountFacade {

	public AccountDTO updateAccount(AccountDTO account);
	
	public AccountDTO getAccount(AccountDTO accountDTO);
	
}
