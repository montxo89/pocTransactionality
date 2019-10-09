package apaas.poc.microorch.facade;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import apaas.poc.microorch.service.dto.LoanDTO;

@Service
public class MicroLoansFacadeImpl extends AbstractFacade implements MicroLoansFacade {

	static Logger logger = Logger.getLogger(MicroLoansFacadeImpl.class.getName());

	@Value("${loan.service.base.url}")
	private String loanBaseUrl;

	@Override
	public LoanDTO updateLoan(LoanDTO loan) {
		logger.info("MicroOrchController MicroTrxMngFacadeImpl entered");
		try {
			loan = postForObject(loanBaseUrl + "/modifyLoan", loan, LoanDTO.class);
		} catch (Exception e) {
			logger.info("MicroOrchController MicroTrxMngFacadeImpl error = " + e.getMessage() + e);
		}
		return loan;
	}

}
