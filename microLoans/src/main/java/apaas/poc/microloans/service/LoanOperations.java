package apaas.poc.microloans.service;

import java.util.ArrayList;

import apaas.poc.microloans.controller.dto.LoanDTO;

public interface LoanOperations {
	
	public void sendLoan(String message);

	public ArrayList<LoanDTO> listAllLoans();
	
	public LoanDTO listLoanByLoanId(String loanId);
	
	public LoanDTO addLoan(LoanDTO loan);
	
	public LoanDTO modifyLoan(LoanDTO loan);
	
	public boolean deleteLoan(LoanDTO loan);
	
}
