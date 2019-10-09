package apaas.poc.microloans.service;

import apaas.poc.microloans.controller.dto.LoanDTO;
import apaas.poc.microloans.data.model.LoanDbModel;

public interface LoanMapping {

	public LoanDTO mapLoanDbModelToLoanDTO(LoanDbModel loanDbModel);

	public LoanDbModel mapLoanDTOToLoanDbModel(LoanDTO LoanDTO);

}
