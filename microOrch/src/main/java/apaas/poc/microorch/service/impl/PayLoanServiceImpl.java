package apaas.poc.microorch.service.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apaas.poc.microorch.controller.dto.LoanRepaymentStatus;
import apaas.poc.microorch.controller.dto.LoanTransactionDTO;
import apaas.poc.microorch.model.TokenTrxManager;
import apaas.poc.microorch.service.AccountService;
import apaas.poc.microorch.service.ClientService;
import apaas.poc.microorch.service.LoanService;
import apaas.poc.microorch.service.PayLoanService;
import apaas.poc.microorch.service.TrxManagerService;
import apaas.poc.microorch.service.dto.AccountDTO;
import apaas.poc.microorch.service.dto.ClientDTO;
import apaas.poc.microorch.service.dto.LoanDTO;

@Service
public class PayLoanServiceImpl implements PayLoanService {

	static Logger logger = Logger.getLogger(PayLoanServiceImpl.class.getName());

	@Autowired
	private LoanService loanService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private TrxManagerService trxManagerService;

	@Override
	public LoanTransactionDTO payLoan(String loanId, LoanTransactionDTO loanTransactionDTO) {

		logger.info("PayLoanServiceImpl payLoan entered.");
		// Only check if client has enough balance in the account
		if (hasEnoughBalanceInAccount(loanTransactionDTO)) {

			logger.info("PayLoanServiceImpl payLoan account has enought balance.");
			loanTransactionDTO = processLoanPayment(loanId, loanTransactionDTO);

		} else {

			logger.info("PayLoanServiceImpl payLoan not enough balance, pay denied.");
			loanTransactionDTO.setStatus(LoanRepaymentStatus.DENIED);

		}

		return loanTransactionDTO;
	}

	private LoanTransactionDTO processLoanPayment(String loanId, LoanTransactionDTO loanTransactionDTO) {

		logger.info("PayLoanServiceImpl processLoanPayment entered.");

		logger.info("PayLoanServiceImpl processLoanPayment recovering trx token.");
		TokenTrxManager tokenTrxManager = generateTransactionalToken(loanId);

		logger.info("PayLoanServiceImpl processLoanPayment update loanTransactionDTO with loan info.");
		LoanDTO loanDTO = updateLoan(loanId, loanTransactionDTO);

		logger.info("PayLoanServiceImpl processLoanPayment update account with accountDTO.");
		AccountDTO accountDTO = updateAccount(loanTransactionDTO);

		// if loan balance == 0 then call clientService that invoke uClient endpoint

		// if (loanDTO.getAmountToPay().compareTo(BigDecimal.ZERO) = 0) {
		// ClientDTO client = updateClient(loanTransactionDTO.getClientId());
		// }

		return updateLoanTransaction(loanDTO, accountDTO, loanTransactionDTO);

	}

	private LoanTransactionDTO updateLoanTransaction(LoanDTO loanDTO, AccountDTO accoutDTO,
			LoanTransactionDTO initialLoanTransactionDTO) {
		LoanTransactionDTO finalLoanTransactionDTO = new LoanTransactionDTO();
		finalLoanTransactionDTO.setAmountToPay(initialLoanTransactionDTO.getAmountToPay());
		finalLoanTransactionDTO.setClientId(initialLoanTransactionDTO.getClientId());
		finalLoanTransactionDTO.setFinalAccountBalance(accoutDTO.getBalance());
		finalLoanTransactionDTO.setFinalLoanBalance(loanDTO.getAmountToPay());
		finalLoanTransactionDTO.setStatus(LoanRepaymentStatus.PAID);
		return finalLoanTransactionDTO;
	}

	private ClientDTO updateClient(String clientId) {
		ClientDTO client = new ClientDTO();
		client.setClientId(clientId);
		client.setDebtFor(false);
		return clientService.updateClient(client);

	}

	private AccountDTO updateAccount(LoanTransactionDTO loanTransactionDTO) {
		AccountDTO account = new AccountDTO();
		account.setClientId(loanTransactionDTO.getClientId());
		account.setAmountToPay(loanTransactionDTO.getAmountToPay());
		return accountService.updateAccount(account);
	}

	private LoanDTO updateLoan(String loanId, LoanTransactionDTO loanTransactionDTO) {
		logger.info("PayLoanServiceImpl updateLoan entered.");
		LoanDTO loan = new LoanDTO();
		loan.setLoanId(loanId);
		loan.setAmountToPay(loanTransactionDTO.getAmountToPay());
		loan.setClientId(loanTransactionDTO.getClientId());
		return loanService.updateLoan(loan);
	}

	private TokenTrxManager generateTransactionalToken(String loanId) {
		logger.info("PayLoanServiceImpl generateTransactionalToken entered.");
		return trxManagerService.recoverToken(loanId);
	}

	/**
	 * Check if the account has enough balance.
	 * 
	 * @param loanTransactionDTO
	 *            the item of the loan.
	 * @return boolean with the info.
	 */
	private boolean hasEnoughBalanceInAccount(LoanTransactionDTO loanTransactionDTO) {
		AccountDTO accountDTO = new AccountDTO();
		accountDTO.setClientId(loanTransactionDTO.getClientId());
		accountDTO.setAmountToPay(loanTransactionDTO.getAmountToPay());
		return accountService.checkAccount(accountDTO);
	}

}
