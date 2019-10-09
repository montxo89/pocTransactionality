package apaas.poc.microorch.service.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apaas.poc.microorch.facade.MicroTrxMngFacade;
import apaas.poc.microorch.model.TokenTrxManager;
import apaas.poc.microorch.service.TrxManagerService;

@Service
public class TrxManagerServiceImpl implements TrxManagerService {

	static Logger logger = Logger.getLogger(TrxManagerServiceImpl.class.getName());

	@Autowired
	private MicroTrxMngFacade microTrxMngFacade;

	@Override
	public TokenTrxManager recoverToken(String loanId) {
		logger.info("MicroOrchController userId service");
		return microTrxMngFacade.recoverToken(loanId);
	}

}
