package apaas.poc.microaccounts.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apaas.poc.microaccounts.controller.dto.AccountDTO;
import apaas.poc.microaccounts.service.AccountService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

	static Logger logger = Logger.getLogger(AccountController.class.getName());

	@Autowired
	private AccountService accountService;

	/**
	 * Endpoint for list all the accounts
	 * 
	 */
	@ApiOperation(value = "List all the accounts")
	@RequestMapping(value = "/listAllAccounts", produces = { "application/json" }, method = RequestMethod.GET)
	public List<AccountDTO> getAccounts() {

		logger.info("MicroAccounts /listAccounts entered");
		return accountService.retrieveAll();

	}

	/**
	 * Endpoint look for an account by clientId
	 * 
	 */
	@ApiOperation(value = "List an account using the user id")
	@RequestMapping(value = "/{clientId}", produces = { "application/json" }, method = RequestMethod.GET)
	public AccountDTO getAccount(@PathVariable("clientId") String clientId) {

		logger.info("MicroAccounts /listAccountAccountId entered");
		return accountService.retrieveAccount(clientId);

	}

	/**
	 * Endpoint add an account
	 * 
	 */
	@RequestMapping(value = "/addAccount", produces = { "application/json" }, method = RequestMethod.POST)
	public AccountDTO addAccount(@RequestBody AccountDTO accountDTO) throws Exception {
		logger.info("MicroAccounts /addAccount entered");
		return accountService.addAccount(accountDTO);

	}

//	/**
//	 * Endpoint modify a account
//	 * 
//	 */
//	@ApiOperation(value = "Modify an account")
//	@RequestMapping(produces = { "application/json" }, method = RequestMethod.PATCH)
//	public AccountDTO updateAccount(@RequestBody AccountDTO account) {
//
//		logger.info("MicroAccounts /modifyAccount entered");
//
//		return accountService.updateAccount(account);
//
//	}
//
//	/**
//	 * Endpoint delete an account
//	 * 
//	 */
//	@ApiOperation(value = "Delete an account")
//	@RequestMapping(value = "/{accountId}", produces = { "application/json" }, method = RequestMethod.DELETE)
//	public boolean deleteAccount(@PathVariable("accountId") String accountId) {
//
//		logger.info("MicroAccounts /deleteAccount entered");
//		return accountService.deleteAccount(accountId);
//
//	}

}
