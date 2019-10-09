package apaas.poc.microloans.service.impl;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import apaas.poc.microloans.controller.dto.LoanDTO;
import apaas.poc.microloans.data.model.LoanDbModel;
import apaas.poc.microloans.service.LoanMapping;

@Service
public class LoanMappingImpl implements LoanMapping {

	static Logger logger = Logger.getLogger(LoanMappingImpl.class.getName());

	@Override
	public LoanDTO mapLoanDbModelToLoanDTO(LoanDbModel loanDbModel) {
		logger.info("Microloans LoanMappingImpl mapLoanDbModelToLoanDTO entered");
		LoanDTO loanDTO = new LoanDTO();
		loanDTO.setClientId(loanDbModel.getUserId());
		loanDTO.setLoanBalance(loanDbModel.getLoanBalance());
		loanDTO.setLoanId(loanDbModel.getLoanId());
		return loanDTO;
	}

	@Override
	public LoanDbModel mapLoanDTOToLoanDbModel(LoanDTO loanDTO) {
		logger.info("Microloans LoanMappingImpl mapLoanDTOToLoanDbModel entered");
		LoanDbModel loanDbModel = new LoanDbModel();
		loanDbModel.setUserId(loanDTO.getClientId());
		loanDbModel.setLoanId(loanDTO.getLoanId());
		loanDbModel.setLoanBalance(loanDTO.getLoanBalance());
		return loanDbModel;
	}

}
