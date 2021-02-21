package com.greedy.semi.member.model.dto;

import java.sql.Date;
import java.util.List;

public class LicenseDTO implements java.io.Serializable {
	
	private String code;
	private String name;
	private String institution;
	private String grade;
	private java.sql.Date issueDate;
	private java.sql.Date expDate;
	private List<LcAttachmentDTO> attachmentList;
	
	public LicenseDTO() {}

	public LicenseDTO(String code, String name, String institution, String grade, Date issueDate, Date expDate,
			List<LcAttachmentDTO> attachmentList) {
		super();
		this.code = code;
		this.name = name;
		this.institution = institution;
		this.grade = grade;
		this.issueDate = issueDate;
		this.expDate = expDate;
		this.attachmentList = attachmentList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public java.sql.Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(java.sql.Date issueDate) {
		this.issueDate = issueDate;
	}

	public java.sql.Date getExpDate() {
		return expDate;
	}

	public void setExpDate(java.sql.Date expDate) {
		this.expDate = expDate;
	}

	public List<LcAttachmentDTO> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<LcAttachmentDTO> attachmentList) {
		this.attachmentList = attachmentList;
	}

	@Override
	public String toString() {
		return "LicenseDTO [code=" + code + ", name=" + name + ", institution=" + institution + ", grade=" + grade
				+ ", issueDate=" + issueDate + ", expDate=" + expDate + ", attachmentList=" + attachmentList + "]";
	}

	
	
}
