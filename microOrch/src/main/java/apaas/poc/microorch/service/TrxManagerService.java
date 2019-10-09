package apaas.poc.microorch.service;

import apaas.poc.microorch.model.TokenTrxManager;

public interface TrxManagerService {

	public TokenTrxManager recoverToken(String loanId);
	
}
