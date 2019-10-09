package apaas.poc.microorch.controller.dto;

public enum LoanRepaymentStatus {
	DENIED("DENIED"),
	PAID("PAID");

	String status;
	
	LoanRepaymentStatus(String status) {
	        this.status = status;
	    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
