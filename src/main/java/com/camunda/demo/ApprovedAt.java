package com.camunda.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApprovedAt {

	private String loanId;

	public ApprovedAt() {
		 this.creationDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		long currentTimestamp = System.currentTimeMillis();
		loanId = String.valueOf(currentTimestamp);
	}

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	private String creationDateTime;

	public String getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(String creationDateTime) {
		this.creationDateTime = creationDateTime;
	}



}
