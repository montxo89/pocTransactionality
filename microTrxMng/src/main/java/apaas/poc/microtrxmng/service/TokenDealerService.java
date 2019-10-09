package apaas.poc.microtrxmng.service;

import apaas.poc.microtrxmng.model.TokenTrxManager;

public interface TokenDealerService {

	public TokenTrxManager returnToken(String userId);

}
