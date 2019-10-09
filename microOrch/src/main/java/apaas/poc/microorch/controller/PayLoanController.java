package apaas.poc.microorch.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apaas.poc.microorch.controller.dto.LoanTransactionDTO;
import apaas.poc.microorch.service.PayLoanService;

@RestController
@RequestMapping(value = "/loan")
public class PayLoanController {

	static Logger logger = Logger.getLogger(PayLoanController.class.getName());

	@Autowired
	private PayLoanService payLoanService;

	/**
	 * EndPoint for paying a loan.
	 * 
	 * @param loanId
	 *            the id of the loan to pay.
	 * @param loanTransactionReq
	 * @return the info od the payment.
	 * @throws Exception
	 *             of any kind.
	 */
	@RequestMapping(value = "/{loanId}", produces = { "application/json" }, method = RequestMethod.POST)
	public LoanTransactionDTO payLoan(@PathVariable("loanId") String loanId,
			@RequestBody LoanTransactionDTO loanTransactionReq) throws Exception {

		logger.info("START: Loan transaction. LoanId: " + loanId + ". " + loanTransactionReq.toString());

		LoanTransactionDTO loanTransactionRes = payLoanService.payLoan(loanId, loanTransactionReq);

		logger.info("END: Loan transaction.");

		return loanTransactionRes;
	}

}
