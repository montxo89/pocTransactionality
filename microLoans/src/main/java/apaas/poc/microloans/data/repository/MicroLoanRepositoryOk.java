package apaas.poc.microloans.data.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apaas.poc.microloans.data.model.LoanDbModel;

@Service
public class MicroLoanRepositoryOk {

	static Logger logger = Logger.getLogger(MicroLoanRepositoryOk.class.getName());

	@Autowired
	private LoanRepository loanRepository;

	public LoanDbModel insertLoan(LoanDbModel loanDbModel) {
		logger.info("microloans MicroLoanRepositoryOk insertLoan entered");
		try {
			return loanRepository.save(loanDbModel);
		} catch (Exception e) {
			logger.info("microloans MicroLoanRepositoryOk insertLoan error = " + e.getMessage() + e);
			return null;
		}
	}

	public boolean modifyLoan(LoanDbModel loanDbModel) {
		logger.info("microloans MicroLoanRepositoryOk modifyLoan entered");
		try {
			BigDecimal amountToPay = loanDbModel.getLoanBalance();
			Optional<LoanDbModel> loanPre = loanRepository.findById(loanDbModel.getUserId());
			loanDbModel.setLoanBalance(loanPre.get().getLoanBalance().subtract(amountToPay));
			loanRepository.save(loanDbModel);
			return true;
		} catch (Exception e) {
			logger.info("microloans MicroLoanRepositoryOk modifyLoan error = " + e.getMessage() + e);
			return false;
		}
	}

	public boolean deleteLoan(LoanDbModel loanDbModel) {
		logger.info("microloans MicroLoanRepositoryOk deleteLoan entered");
		try {
			loanRepository.delete(loanDbModel);
			return true;
		} catch (Exception e) {
			logger.info("microloans MicroLoanRepositoryOk deleteLoan error = " + e.getMessage() + e);
			return false;
		}
	}

	public ArrayList<LoanDbModel> listAllLoans() {
		try {
			return (ArrayList<LoanDbModel>) loanRepository.findAll();
		} catch (Exception e) {
			logger.info("microloans MicroLoanRepositoryOk listAllLoans error = " + e.getMessage() + e);
			return null;
		}
	}

	public LoanDbModel showLoanById(String id) {
		try {
			Optional<LoanDbModel> loanDbOpt = loanRepository.findById(id);
			return loanDbOpt.get();
		} catch (Exception e) {
			logger.info("microloans MicroLoanRepositoryOk showLoanById error = " + e.getMessage() + e);
			return null;
		}
	}

}
