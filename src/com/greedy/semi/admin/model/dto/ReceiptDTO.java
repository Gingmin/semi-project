package com.greedy.semi.admin.model.dto;

import java.sql.Date;

import com.greedy.semi.member.model.dto.MemberDTO;

public class ReceiptDTO implements java.io.Serializable {

	private int reNo;
	private int no;
	private java.sql.Date reDate;
	private String reCode;
	private int totalPrice;
	private String ccStatus;
	
	private MemberDTO memberDTO;
	private ReceiptCategoryDTO receiptCategoryDTO;
	
	public ReceiptDTO() {}

	public ReceiptDTO(int reNo, int no, Date reDate, String reCode, int totalPrice, String ccStatus,
			MemberDTO memberDTO, ReceiptCategoryDTO receiptCategoryDTO) {
		super();
		this.reNo = reNo;
		this.no = no;
		this.reDate = reDate;
		this.reCode = reCode;
		this.totalPrice = totalPrice;
		this.ccStatus = ccStatus;
		this.memberDTO = memberDTO;
		this.receiptCategoryDTO = receiptCategoryDTO;
	}

	public int getReNo() {
		return reNo;
	}

	public void setReNo(int reNo) {
		this.reNo = reNo;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public java.sql.Date getReDate() {
		return reDate;
	}

	public void setReDate(java.sql.Date reDate) {
		this.reDate = reDate;
	}

	public String getReCode() {
		return reCode;
	}

	public void setReCode(String reCode) {
		this.reCode = reCode;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getCcStatus() {
		return ccStatus;
	}

	public void setCcStatus(String ccStatus) {
		this.ccStatus = ccStatus;
	}

	public MemberDTO getMemberDTO() {
		return memberDTO;
	}

	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}

	public ReceiptCategoryDTO getReceiptCategoryDTO() {
		return receiptCategoryDTO;
	}

	public void setReceiptCategoryDTO(ReceiptCategoryDTO receiptCategoryDTO) {
		this.receiptCategoryDTO = receiptCategoryDTO;
	}

	@Override
	public String toString() {
		return "ReceiptDTO [reNo=" + reNo + ", no=" + no + ", reDate=" + reDate + ", reCode=" + reCode + ", totalPrice="
				+ totalPrice + ", ccStatus=" + ccStatus + ", memberDTO=" + memberDTO + ", receiptCategoryDTO="
				+ receiptCategoryDTO + "]";
	}

	

	
	
	
}
