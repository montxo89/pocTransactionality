package apaas.poc.microorch.service.impl;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apaas.poc.microorch.facade.MicroLoansFacade;
import apaas.poc.microorch.service.LoanService;
import apaas.poc.microorch.service.dto.LoanDTO;

@Service
public class LoanServiceImpl implements LoanService {

	static Logger logger = Logger.getLogger(LoanServiceImpl.class.getName());

	@Autowired
	private MicroLoansFacade microLoansFacade;

	@Override
	public LoanDTO updateLoan(LoanDTO loan) {

		logger.info("LoanServiceImpl updateLoan entered.");

		return microLoansFacade.updateLoan(loan);
	}

}
