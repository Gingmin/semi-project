package com.greedy.semi.shop.model.dto;

import java.sql.Date;

public class PurchaseProductDTO implements java.io.Serializable{
	private String purchaseCode;
	private int memberNo;
	private String productCode;
	private int purchasePrice;
	private java.sql.Date purchaseDate;
	private int purchasePermitNo;
	private String purchaseStatus;
	public PurchaseProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PurchaseProductDTO(String purchaseCode, int memberNo, String productCode, int purchasePrice,
			Date purchaseDate, int purchasePermitNo, String purchaseStatus) {
		super();
		this.purchaseCode = purchaseCode;
		this.memberNo = memberNo;
		this.productCode = productCode;
		this.purchasePrice = purchasePrice;
		this.purchaseDate = purchaseDate;
		this.purchasePermitNo = purchasePermitNo;
		this.purchaseStatus = purchaseStatus;
	}
	public String getPurchaseCode() {
		return purchaseCode;
	}
	public void setPurchaseCode(String purchaseCode) {
		this.purchaseCode = purchaseCode;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public int getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public java.sql.Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(java.sql.Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getPurchasePermitNo() {
		return purchasePermitNo;
	}
	public void setPurchasePermitNo(int purchasePermitNo) {
		this.purchasePermitNo = purchasePermitNo;
	}
	public String getPurchaseStatus() {
		return purchaseStatus;
	}
	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
	@Override
	public String toString() {
		return "PurchaseProductDTO [purchaseCode=" + purchaseCode + ", memberNo=" + memberNo + ", productCode="
				+ productCode + ", purchasePrice=" + purchasePrice + ", purchaseDate=" + purchaseDate
				+ ", purchasePermitNo=" + purchasePermitNo + ", purchaseStatus=" + purchaseStatus + "]";
	}

}
