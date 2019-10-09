package apaas.poc.microloans.service.impl;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import apaas.poc.microloans.controller.dto.LoanDTO;
import apaas.poc.microloans.data.model.LoanDbModel;
import apaas.poc.microloans.data.repository.MicroLoanRepositoryOk;
import apaas.poc.microloans.service.LoanMapping;
import apaas.poc.microloans.service.LoanOperations;

@Service
public class LoanOperationImpl implements LoanOperations {

	static Logger logger = Logger.getLogger(LoanOperationImpl.class.getName());

	@Autowired
	private MicroLoanRepositoryOk microLoanRepositoryOk;

	@Autowired
	private LoanMapping loanMapping;

	HttpHeaders headers;
	HttpEntity<String> requestEntity;

	@Override
	public void sendLoan(String message) {
		headers = new HttpHeaders();
		requestEntity = new HttpEntity<String>(message, headers);
		RestTemplate rt = new RestTemplate();
		String answer;

		/**
		 * assume CRUD operation fail for queue testing and send operation to tx manager
		 */
		try {
			answer = rt
					.exchange("http://localhost:8080/message/" + message, HttpMethod.GET, requestEntity, String.class)
					.getBody();
			logger.info(answer);
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getMessage());
		}

	}

	@Override
	public ArrayList<LoanDTO> listAllLoans() {
		logger.info("Microloans LoanOperationImpl listAllLoans entered");
		ArrayList<LoanDbModel> listaLoans = new ArrayList<>();
		listaLoans = microLoanRepositoryOk.listAllLoans();
		ArrayList<LoanDTO> listToReturn = new ArrayList<>();
		for (LoanDbModel loanDbModel : listaLoans) {
			listToReturn.add(loanMapping.mapLoanDbModelToLoanDTO(loanDbModel));
		}
		return listToReturn;
	}

	@Override
	public LoanDTO listLoanByLoanId(String loanId) {
		logger.info("Microloans LoanOperationImpl listLoanByLoanId entered");

		return null;
	}

	@Override
	public LoanDTO addLoan(LoanDTO loan) {
		logger.info("Microloans LoanOperationImpl addLoan entered");
		LoanDbModel loanDbModel = new LoanDbModel();
		loanDbModel = loanMapping.mapLoanDTOToLoanDbModel(loan);
		loanDbModel = microLoanRepositoryOk.insertLoan(loanDbModel);
		LoanDTO returnLoan = loanMapping.mapLoanDbModelToLoanDTO(loanDbModel);
		return returnLoan;
	}

	@Override
	public LoanDTO modifyLoan(LoanDTO loan) {
		logger.info("Microloans LoanOperationImpl modifyLoan entered");
		return null;
	}

	@Override
	public boolean deleteLoan(LoanDTO loan) {
		logger.info("Microloans LoanOperationImpl deleteLoan entered");
		return false;
	}
}
