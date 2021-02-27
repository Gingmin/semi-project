package com.greedy.semi.admin.model.dto;

public class ReceiptCategoryDTO implements java.io.Serializable {

	private String recCode;
	private String recName;
	
	public ReceiptCategoryDTO() {}

	public ReceiptCategoryDTO(String recCode, String recName) {
		super();
		this.recCode = recCode;
		this.recName = recName;
	}

	public String getRecCode() {
		return recCode;
	}

	public void setRecCode(String recCode) {
		this.recCode = recCode;
	}

	public String getRecName() {
		return recName;
	}

	public void setRecName(String recName) {
		this.recName = recName;
	}

	@Override
	public String toString() {
		return "ReceiptCategoryDTO [recCode=" + recCode + ", recName=" + recName + "]";
	}
	
	
	
}
