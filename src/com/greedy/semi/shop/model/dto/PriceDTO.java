package com.greedy.semi.shop.model.dto;

public class PriceDTO implements java.io.Serializable{
	private String productCode;
	private String productName;
	private int productPrice;
	
	public PriceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PriceDTO(String productCode, String productName, int productPrice) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "priceDTO [productCode=" + productCode + ", productName=" + productName + ", productPrice="
				+ productPrice + "]";
	}
	
}
