package apaas.poc.microorch.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class LoanDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String loanId;
	private String clientId;
	private BigDecimal amountToPay;

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
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

}
