package com.greedy.semi.member.model.dto;

public class TrainerInfoDTO implements java.io.Serializable {

	private int no;
	private String accountNumber;
	private String bankName;
	private String accountHolder;
	private String approvalStatus;
	private int averageScore;
	
	public TrainerInfoDTO() {}

	public TrainerInfoDTO(int no, String accountNumber, String bankName, String accountHolder, String approvalStatus,
			int averageScore) {
		super();
		this.no = no;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.accountHolder = accountHolder;
		this.approvalStatus = approvalStatus;
		this.averageScore = averageScore;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public int getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(int averageScore) {
		this.averageScore = averageScore;
	}

	@Override
	public String toString() {
		return "TrainerInfoDTO [no=" + no + ", accountNumber=" + accountNumber + ", bankName=" + bankName
				+ ", accountHolder=" + accountHolder + ", approvalStatus=" + approvalStatus + ", averageScore="
				+ averageScore + "]";
	}
	
}
