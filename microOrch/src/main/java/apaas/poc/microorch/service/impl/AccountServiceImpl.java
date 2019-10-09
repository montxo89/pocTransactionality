package apaas.poc.microorch.service.impl;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import apaas.poc.microorch.facade.MicroAccountFacade;
import apaas.poc.microorch.service.AccountService;
import apaas.poc.microorch.service.dto.AccountDTO;

@Service
public class AccountServiceImpl implements AccountService {

	@Value("${account.service.base.url}")
	private String accountBaseUrl;

	static Logger logger = Logger.getLogger(AccountServiceImpl.class.getName());

	@Autowired
	private MicroAccountFacade microAccountFacade;

	private static final int ZERO = 0;

	@Override
	public AccountDTO updateAccount(AccountDTO account) {

		logger.info("AccountServiceImpl updateAccount entered.");
		return microAccountFacade.updateAccount(account);

	}

	@Override
	public boolean checkAccount(AccountDTO accountDTO) {

		logger.info("AccountServiceImpl checkAccount entered.");
		AccountDTO account = microAccountFacade.getAccount(accountDTO);
		BigDecimal finalBalance = account.getBalance().subtract(accountDTO.getAmountToPay());

		return (finalBalance.compareTo(BigDecimal.ZERO) > ZERO);
	}

}
