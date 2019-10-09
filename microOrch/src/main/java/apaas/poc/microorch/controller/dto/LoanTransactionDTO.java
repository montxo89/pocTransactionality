package apaas.poc.microorch.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LoanTransactionDTO  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String clientId;
	
	private BigDecimal amountToPay;
	
	private BigDecimal finalAccountBalance;
	
	private BigDecimal finalLoanBalance;
	
	private LoanRepaymentStatus status;

	
	
	
	
	public BigDecimal getFinalAccountBalance() {
		return finalAccountBalance;
	}

	public void setFinalAccountBalance(BigDecimal finalAccountBalance) {
		this.finalAccountBalance = finalAccountBalance;
	}

	public BigDecimal getFinalLoanBalance() {
		return finalLoanBalance;
	}

	public void setFinalLoanBalance(BigDecimal finalLoanBalance) {
		this.finalLoanBalance = finalLoanBalance;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public BigDecimal getAmountToPay() {
		return amountToPay;
	}

	public void setAmountToPay(BigDecimal amountToPay) {
		this.amountToPay = amountToPay;
	}

	public LoanRepaymentStatus getStatus() {
		return status;
	}

	public void setStatus(LoanRepaymentStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LoanTransactionDTO [clientId=" + clientId + ", amountToPay=" + amountToPay + ", status=" + status + "]";
	}
	

}
