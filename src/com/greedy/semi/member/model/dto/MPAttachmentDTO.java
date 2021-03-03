package com.greedy.semi.member.model.dto;

import java.sql.Date;

public class MPAttachmentDTO implements java.io.Serializable {

	private int no;
	private int code;
	private String filePath;
	private String originalName;
	private String fileName;
	private String thumbnailPath;
	private java.sql.Date uploadDate;
	private String attachmentStatus;
	
	public MPAttachmentDTO() {}

	public MPAttachmentDTO(int no, int code, String filePath, String originalName, String fileName,
			String thumbnailPath, Date uploadDate, String attachmentStatus) {
		super();
		this.no = no;
		this.code = code;
		this.filePath = filePath;
		this.originalName = originalName;
		this.fileName = fileName;
		this.thumbnailPath = thumbnailPath;
		this.uploadDate = uploadDate;
		this.attachmentStatus = attachmentStatus;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
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

	public String getAttachmentStatus() {
		return attachmentStatus;
	}

	public void setAttachmentStatus(String attachmentStatus) {
		this.attachmentStatus = attachmentStatus;
	}

	@Override
	public String toString() {
		return "MPAttachmentDTO [no=" + no + ", code=" + code + ", filePath=" + filePath + ", originalName="
				+ originalName + ", fileName=" + fileName + ", thumbnailPath=" + thumbnailPath + ", uploadDate="
				+ uploadDate + ", attachmentStatus=" + attachmentStatus + "]";
	}
	
	
}
