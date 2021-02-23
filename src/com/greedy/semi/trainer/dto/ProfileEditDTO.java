package com.greedy.semi.trainer.dto;

import java.io.Serializable;

public class ProfileEditDTO implements Serializable {
	
	private int profileNo;
	private int trainerNo;
	private String originalName;
	private String savedName;
	private String savePath;
	private String thumbnailPath;
	private String fileType;
	
	public ProfileEditDTO() {}

	public ProfileEditDTO(int profileNo, int trainerNo, String originalName, String savedName, String savePath,
			String thumbnailPath, String fileType) {
		super();
		this.profileNo = profileNo;
		this.trainerNo = trainerNo;
		this.originalName = originalName;
		this.savedName = savedName;
		this.savePath = savePath;
		this.thumbnailPath = thumbnailPath;
		this.fileType = fileType;
	}

	public int getProfileNo() {
		return profileNo;
	}

	public void setProfileNo(int profileNo) {
		this.profileNo = profileNo;
	}

	public int getTrainerNo() {
		return trainerNo;
	}

	public void setTrainerNo(int trainerNo) {
		this.trainerNo = trainerNo;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public String getSavedName() {
		return savedName;
	}

	public void setSavedName(String savedName) {
		this.savedName = savedName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getThumbnailPath() {
		return thumbnailPath;
	}

	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return "ProfileEditDTO [profileNo=" + profileNo + ", trainerNo=" + trainerNo + ", originalName=" + originalName
				+ ", savedName=" + savedName + ", savePath=" + savePath + ", thumbnailPath=" + thumbnailPath
				+ ", fileType=" + fileType + "]";
	}

	

}
