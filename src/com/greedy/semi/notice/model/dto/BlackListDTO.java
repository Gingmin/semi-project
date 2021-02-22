package com.greedy.semi.notice.model.dto;

import java.sql.Date;

import com.greedy.semi.member.model.dto.MemberDTO;

public class BlackListDTO {
	
	private int no;
	private int memberNo;
	private int reportedMemberNo;
	private MemberDTO writer;
	private String reportCode;
	private java.sql.Date reportDate;
	private String reason;
	
	public BlackListDTO() {}

	public BlackListDTO(int no, int memberNo, int reportedMemberNo, MemberDTO writer, String reportCode,
			Date reportDate, String reason) {
		super();
		this.no = no;
		this.memberNo = memberNo;
		this.reportedMemberNo = reportedMemberNo;
		this.writer = writer;
		this.reportCode = reportCode;
		this.reportDate = reportDate;
		this.reason = reason;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getReportedMemberNo() {
		return reportedMemberNo;
	}

	public void setReportedMemberNo(int reportedMemberNo) {
		this.reportedMemberNo = reportedMemberNo;
	}

	public MemberDTO getWriter() {
		return writer;
	}

	public void setWriter(MemberDTO writer) {
		this.writer = writer;
	}

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public java.sql.Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(java.sql.Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "BlackListDTO [no=" + no + ", memberNo=" + memberNo + ", reportedMemberNo=" + reportedMemberNo
				+ ", writer=" + writer + ", reportCode=" + reportCode + ", reportDate=" + reportDate + ", reason="
				+ reason + "]";
	}

	
	
}
