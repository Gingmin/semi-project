package com.greedy.semi.notice.model.dto;

public class CategoryDTO {
	
	private String categoryCode;
	private String categoryKind;
	
	public CategoryDTO() {}

	public CategoryDTO(String categoryCode, String categoryKind) {
		super();
		this.categoryCode = categoryCode;
		this.categoryKind = categoryKind;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getCategoryKind() {
		return categoryKind;
	}

	public void setCategoryKind(String categoryKind) {
		this.categoryKind = categoryKind;
	}

	@Override
	public String toString() {
		return "CategoryDTO [categoryCode=" + categoryCode + ", categoryKind=" + categoryKind + "]";
	}
	
	
}
