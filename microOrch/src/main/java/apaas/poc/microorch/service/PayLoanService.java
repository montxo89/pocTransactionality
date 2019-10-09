package apaas.poc.microorch.service;

import apaas.poc.microorch.controller.dto.LoanTransactionDTO;

public interface PayLoanService {

	public LoanTransactionDTO payLoan(String loanId, LoanTransactionDTO loanTransactionDTO);

}
