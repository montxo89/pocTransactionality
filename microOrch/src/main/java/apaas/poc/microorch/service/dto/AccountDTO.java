package apaas.poc.microorch.service.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.lang.Nullable;

public class AccountDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String clientId;
	private BigDecimal amountToPay;
	@Nullable
	private BigDecimal balance;

	public BigDecimal getAmountToPay() {
		return amountToPay;
	}

	public void setAmountToPay(BigDecimal amountToPay) {
		this.amountToPay = amountToPay;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
