package org.example.stylekit;

import lombok.Data;

@Data
public class TaskOptions {
	public static final int APPLY = 1;
	public static final int EXTRACT = 2;
	public static final int ANALYZE = 3;

	private String src; // files or directories for applying code style
	private String target; // files or directories for extracting code style
	/**
	 * A target directory or file path where the style-transferred code or analysis results will be saved.
	 * <p>
	 * If {@link #src} contains multiple paths and {@link #resOutPath} is a directory,
	 * each input source will generate a corresponding output file in this directory, preserving
	 * the original file names.
	 * <p>
	 */
	private String resOutPath;
	private String styleOutPath;
	private int opId = APPLY;
	private String language;
	private boolean overrideSource;
	private boolean isOut2file; // output to file, otherwise output to directory
}
