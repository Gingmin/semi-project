package com.greedy.semi.trainer.dto;

import java.io.Serializable;
import java.sql.Date;

public class ClassDTO implements Serializable {
	
	private int number;
	private String name;
	private String type;
	private String intro;
	private String introduce;
	private String insertDate;
	
	public ClassDTO() {}

	public ClassDTO(int number, String name, String type, String intro, String introduce, String insertDate) {
		super();
		this.number = number;
		this.name = name;
		this.type = type;
		this.intro = intro;
		this.introduce = introduce;
		this.insertDate = insertDate;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getIntro() {
		return intro;
	}

	public String getIntroduce() {
		return introduce;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	@Override
	public String toString() {
		return "ClassDTO [number=" + number + ", name=" + name + ", type=" + type + ", intro=" + intro + ", introduce="
				+ introduce + ", insertDate=" + insertDate + "]";
	}
	
	
	

}
