package com.greedy.semi.member.model.dto;

public class TrainerLicenseDTO implements java.io.Serializable {
	
	private int manageNo;
	private int no;
	private String code;
	
	public TrainerLicenseDTO() {}

	public TrainerLicenseDTO(int manageNo, int no, String code) {
		super();
		this.manageNo = manageNo;
		this.no = no;
		this.code = code;
	}

	public int getManageNo() {
		return manageNo;
	}

	public void setManageNo(int manageNo) {
		this.manageNo = manageNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "TrainerLicenseDTO [manageNo=" + manageNo + ", no=" + no + ", code=" + code + "]";
	}
	
	
	
}
