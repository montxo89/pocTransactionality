package apaas.poc.microloans.controller;

import java.util.ArrayList;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apaas.poc.microloans.controller.dto.LoanDTO;
import apaas.poc.microloans.service.LoanOperations;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/loan")
public class LoanController {

	@Autowired
	private LoanOperations loanOperations;

	static Logger logger = Logger.getLogger(LoanController.class.getName());

	/**
	 * Endpoint to manage a loan
	 * 
	 * @param message
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/message/{message}", produces = { "application/json" }, method = RequestMethod.GET)
	public HttpEntity<String> sendLoanEndPoint(@PathVariable("message") final String message) throws Exception {
		logger.info("MicroLoans received from MicroOrch: " + message);
		loanOperations.sendLoan(message);
		return new HttpEntity<String>(new HttpHeaders());
	}

	/**
	 * Endpoint for list all the loans
	 * 
	 */
	@ApiOperation(value = "List all the loans")
	@RequestMapping(value = "/listLoans", produces = { "application/json" }, method = RequestMethod.GET)
	public ArrayList<LoanDTO> listAllLoans() {
		logger.info("MicroLoans /listLoans entered");
		return loanOperations.listAllLoans();
	}

	/**
	 * Endpoint look for a loan by loanId
	 * 
	 */
	@ApiOperation(value = "List a loan using the user id")
	@RequestMapping(value = "/{loanId}", produces = { "application/json" }, method = RequestMethod.GET)
	public LoanDTO listLoanByLoanId(@PathVariable("loanId") String loanId) {
		logger.info("MicroLoans /listLoanLoanId entered");
		return loanOperations.listLoanByLoanId(loanId);
	}

	/**
	 * Endpoint add a loan
	 * 
	 */
	@ApiOperation(value = "Add a new loan")
	@RequestMapping(value = "/addLoan", produces = { "application/json" }, method = RequestMethod.POST)
	public LoanDTO addLOan(@RequestBody LoanDTO loan) {
		logger.info("MicroLoans /addLOan entered");
		return loanOperations.addLoan(loan);
	}

	/**
	 * Endpoint modify a loan
	 * 
	 */
	@ApiOperation(value = "Modify a loan")
	@RequestMapping(value = "/modifyLoan", produces = { "application/json" }, method = RequestMethod.POST)
	public LoanDTO modifyLOan(@RequestBody LoanDTO loan) {
		logger.info("MicroLoans /modifyLoan entered");
		return loanOperations.modifyLoan(loan);
	}

	/**
	 * Endpoint delete a loan
	 * 
	 */
	@ApiOperation(value = "Delete a loan")
	@RequestMapping(value = "/deleteLoan", produces = { "application/json" }, method = RequestMethod.POST)
	public boolean deleteLOan(@RequestBody LoanDTO loan) {
		logger.info("MicroLoans /deleteLoan entered");
		return loanOperations.deleteLoan(loan);
	}

}
