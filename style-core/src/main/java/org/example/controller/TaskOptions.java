package org.example.controller;

public class TaskOptions {
	private String src; // files or directories for applying code style
	private String target; // files or directories for extracting code style
	private String resOutPath; // output directory for results or output file
	private String styleOutPath; // output path for extracted code style
	private boolean doCheck; // whether to perform style checking only
	private String language;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


	public boolean isOverrideSource() {
		return overrideSource;
	}

	public void setOverrideSource(boolean overrideSource) {
		this.overrideSource = overrideSource;
	}

	private boolean overrideSource; // whether to override source files

	public String getResOutPath() {
		return resOutPath;
	}

	public void setResOutPath(String resOutPath) {
		this.resOutPath = resOutPath;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getStyleOutPath() {
		return styleOutPath;
	}

	public void setStyleOutPath(String styleOutPath) {
		this.styleOutPath = styleOutPath;
	}

	public boolean isDoCheck() {
		return doCheck;
	}

	public void setDoCheck(boolean doCheck) {
		this.doCheck = doCheck;
	}


}
