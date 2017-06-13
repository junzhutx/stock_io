package com.rainston.common.model;

import java.util.List;

public class ServiceInfo {
	String version;
	List<String> classpath;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<String> getClasspath() {
		return classpath;
	}

	public void setClasspath(List<String> classpath) {
		this.classpath = classpath;
	}
}
