package apaas.poc.microorch.service.dto;

import java.io.Serializable;

public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String clientId;
	private boolean debtFor;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public boolean getDebtFor() {
		return debtFor;
	}

	public void setDebtFor(boolean debtFor) {
		this.debtFor = debtFor;
	}

}
