package com.greedy.semi.member.model.dto;

import java.sql.Date;

public class LcAttachmentDTO implements java.io.Serializable {

	private int no;
	private String code;
	private String filePath;
	private String originalName;
	private String fileName;
	private String thumbnailPath;
	private java.sql.Date uploadDate;
	private String status;
	
	public LcAttachmentDTO() {}

	public LcAttachmentDTO(int no, String code, String filePath, String originalName, String fileName,
			String thumbnailPath, Date uploadDate, String status) {
		super();
		this.no = no;
		this.code = code;
		this.filePath = filePath;
		this.originalName = originalName;
		this.fileName = fileName;
		this.thumbnailPath = thumbnailPath;
		this.uploadDate = uploadDate;
		this.status = status;
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

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public java.sql.Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(java.sql.Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LcAttachmentDTO [no=" + no + ", code=" + code + ", filePath=" + filePath + ", originalName="
				+ originalName + ", fileName=" + fileName + ", thumbnailPath=" + thumbnailPath + ", uploadDate="
				+ uploadDate + ", status=" + status + "]";
	}

	
	
	
}
