package org.example.stylekit;

public class TaskOptions {
	public static final int APPLY = 1;
	public static final int EXTRACT = 2;
	public static final int ANALYZE = 3;

	private String src; // files or directories for applying code style
	private String target; // files or directories for extracting code style
	private String resOutPath; // output directory for results or output file
	/**
	 * A target directory or file path where the processed code or analysis results will be saved.
	 * <p>
	 * If {@link #src} contains multiple paths and {@link #outPath} is a directory,
	 * each input source will generate a corresponding output file in this directory, preserving
	 * the original file names.
	 * <p>
	 */
	private String outPath;
	private int opId;
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

	public String getOutPath() {
		return outPath;
	}

	public void setOutPath(String outPath) {
		this.outPath = outPath;
	}


	public void setOpId(int opId) {
		this.opId = opId;
	}

	public int getOpId() {
		return opId;
	}
}
