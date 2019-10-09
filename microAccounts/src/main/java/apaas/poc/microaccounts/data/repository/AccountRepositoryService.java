package apaas.poc.microaccounts.data.repository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apaas.poc.microaccounts.data.model.Account;

@Service
public class AccountRepositoryService {

	static Logger logger = Logger.getLogger(AccountRepositoryService.class.getName());

	@Autowired
	private AccountsRepository accountsRepository;

	public Account insertAccount(Account accountDbModel) {
		logger.info("microaccounts MicroaccountsRepositoryOk insertAccount entered");
		try {
			return accountsRepository.save(accountDbModel);
		} catch (Exception e) {
			logger.info("microaccounts MicroaccountsRepositoryOk insertAccount error = " + e.getMessage() + e);
			return null;
		}
	}

	public Account modifyAccount(Account accountDbModel) {
		logger.info("microaccounts MicroaccountsRepositoryOk modifyAccount entered");
		try {
			return accountsRepository.save(accountDbModel);
		} catch (Exception e) {
			logger.info("microaccounts MicroaccountsRepositoryOk modifyAccount error = " + e.getMessage() + e);
			return null;
		}
	}

	public boolean deleteAccount(String accountId) {
		logger.info("microaccounts MicroaccountsRepositoryOk deleteAccount entered");
		try {
			accountsRepository.deleteById(accountId);
			return true;
		} catch (Exception e) {
			logger.info("microaccounts MicroaccountsRepositoryOk deleteAccount error = " + e.getMessage() + e);
			return false;
		}
	}

	public List<Account> listAllAccounts() {
		logger.info("microaccounts MicroaccountsRepositoryOk listAllAccounts entered");
		try {
			return (List<Account>) accountsRepository.findAll();
		} catch (Exception e) {
			logger.info("microaccounts MicroaccountsRepositoryOk listAllAccounts error = " + e.getMessage() + e);
			return null;
		}
	}

	public Account showAccountById(String id) {
		try {
			Optional<Account> accountDbOpt = accountsRepository.findById(id);
			return accountDbOpt.get();
		} catch (Exception e) {
			logger.info("microaccounts MicroaccountsRepositoryOk showAccountById error = " + e.getMessage() + e);
			return null;
		}
	}

}