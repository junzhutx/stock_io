package com.rainston.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "processedcsv")
public class Processedcsv {
	@Id
	String id;
	
	private String fileName;
	private Long fileCreateTime;
	private Long fileSize;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getFileCreateTime() {
		return fileCreateTime;
	}

	public void setFileCreateTime(Long fileCreateTime) {
		this.fileCreateTime = fileCreateTime;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
}
