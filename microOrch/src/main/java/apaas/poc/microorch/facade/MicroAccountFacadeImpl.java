package apaas.poc.microorch.facade;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import apaas.poc.microorch.service.dto.AccountDTO;

@Service
public class MicroAccountFacadeImpl extends AbstractFacade implements MicroAccountFacade {

	@Value("${account.service.base.url}")
	private String accountBaseUrl;

	static Logger logger = Logger.getLogger(MicroAccountFacadeImpl.class.getName());

	@Override
	public AccountDTO updateAccount(AccountDTO account) {
		logger.info("MicroOrchController MicroAccountFacadeImpl entered");
		try {
			account = postForObject(accountBaseUrl + "/idUserService", account, AccountDTO.class);
		} catch (Exception e) {
			logger.info("MicroOrchController MicroAccountFacadeImpl error = " + e.getMessage() + e);
		}
		return account;
	}

	@Override
	public AccountDTO getAccount(AccountDTO accountDTO) {
		logger.info("MicroOrchController MicroAccountFacadeImpl entered");
		try {
			String url = accountBaseUrl + "/" + accountDTO.getClientId();
			logger.info("MicroOrchController MicroAccountFacadeImpl the url is = " + url);
			// accountDTO = postForObject(url, accountDTO, AccountDTO.class);
			accountDTO = getForObject(url, AccountDTO.class);
		} catch (Exception e) {
			logger.info("MicroOrchController MicroAccountFacadeImpl error = " + e.getMessage() + " / " + e);
		}
		return accountDTO;
	}

}
