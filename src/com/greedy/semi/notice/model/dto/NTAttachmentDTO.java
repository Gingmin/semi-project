package com.greedy.semi.notice.model.dto;

import java.sql.Date;

public class NTAttachmentDTO implements java.io.Serializable{
	
	private int attachmentNo;
	private int noticeNo;
	private String filePath;
	private String originalName;
	private String fileName;
	private String thumbnailPath;
	private java.sql.Date uploadDate;
	private String attachmentStatus;
	
	public NTAttachmentDTO() {}

	public NTAttachmentDTO(int attachmentNo, int noticeNo, String filePath, String originalName, String fileName,
			String thumbnailPath, Date uploadDate, String attachmentStatus) {
		super();
		this.attachmentNo = attachmentNo;
		this.noticeNo = noticeNo;
		this.filePath = filePath;
		this.originalName = originalName;
		this.fileName = fileName;
		this.thumbnailPath = thumbnailPath;
		this.uploadDate = uploadDate;
		this.attachmentStatus = attachmentStatus;
	}

	public int getAttachmentNo() {
		return attachmentNo;
	}

	public void setAttachmentNo(int attachmentNo) {
		this.attachmentNo = attachmentNo;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
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
		return "NTAttachmentDTO [attachmentNo=" + attachmentNo + ", noticeNo=" + noticeNo + ", filePath=" + filePath
				+ ", originalName=" + originalName + ", fileName=" + fileName + ", thumbnailPath=" + thumbnailPath
				+ ", uploadDate=" + uploadDate + ", attachmentStatus=" + attachmentStatus + "]";
	}
	
	
}
