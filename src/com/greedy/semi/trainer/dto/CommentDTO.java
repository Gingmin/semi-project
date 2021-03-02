package com.greedy.semi.trainer.dto;

import java.io.Serializable;

public class CommentDTO implements Serializable {

	private int no;
	private String writer;
	private String content;
	private String writeDate;
	
	public CommentDTO() {}

	public CommentDTO(int no, String writer, String content, String writeDate) {
		super();
		this.no = no;
		this.writer = writer;
		this.content = content;
		this.writeDate = writeDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "CommentDTO [no=" + no + ", writer=" + writer + ", content=" + content + ", writeDate=" + writeDate
				+ "]";
	}
	
	
}
