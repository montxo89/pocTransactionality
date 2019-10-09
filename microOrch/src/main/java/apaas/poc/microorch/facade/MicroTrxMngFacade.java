package apaas.poc.microorch.facade;

import apaas.poc.microorch.model.TokenTrxManager;

public interface MicroTrxMngFacade {

	public TokenTrxManager recoverToken(String loanId);

}
