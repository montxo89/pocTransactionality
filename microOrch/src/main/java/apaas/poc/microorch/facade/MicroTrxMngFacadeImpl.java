package apaas.poc.microorch.facade;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import apaas.poc.microorch.model.TokenTrxManager;

@Service
public class MicroTrxMngFacadeImpl extends AbstractFacade implements MicroTrxMngFacade {

	static Logger logger = Logger.getLogger(MicroTrxMngFacadeImpl.class.getName());

	@Value("${txmngr.service.base.url}")
	private String trxMngBaseUrl;

	@Override
	public TokenTrxManager recoverToken(String loanId) {
		logger.info("MicroOrchController MicroTrxMngFacadeImpl entered");
		TokenTrxManager tokenTrxManager = new TokenTrxManager();
		try {
			String url = trxMngBaseUrl + "/recoverToken/" + loanId;
			logger.info("MicroOrchController MicroTrxMngFacadeImpl the url = " + url);
			tokenTrxManager = getForObject(url, TokenTrxManager.class);
		} catch (Exception e) {
			logger.info("MicroOrchController MicroTrxMngFacadeImpl error = " + e.getMessage() + e);
		}
		return tokenTrxManager;
	}

}
