package apaas.poc.microtrxmng.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import apaas.poc.microtrxmng.model.TokenTrxManager;

@Service
public class TokenDealerServiceImpl implements TokenDealerService {

	static Logger logger = Logger.getLogger(TokenDealerServiceImpl.class.getName());

	@Override
	public TokenTrxManager returnToken(String userId) {
		logger.info("MicroTrxMngController TokenDealer entered");
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TokenTrxManager tokenTrxManager = new TokenTrxManager();
		tokenTrxManager.setToken(timeStamp + userId);
		return tokenTrxManager;
	}

}
