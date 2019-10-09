package apaas.poc.microloans.controller.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LoanDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String clientId;
	private String loanId;
	private BigDecimal loanBalance;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public BigDecimal getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(BigDecimal loanBalance) {
		this.loanBalance = loanBalance;
	}

}
