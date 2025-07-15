public class Main {
	public void setHeaderFiles(String... headerFiles) {
		final String[] files;
		if (headerFiles == null) {
			files = CommonUtil.EMPTY_STRING_ARRAY;
		}
		else {
			files = headerFiles.clone();
		}

		headerFilesMetadata.clear();

		for (final String headerFile : files) {
			headerFilesMetadata.add(HeaderFileMetadata.createFromFile(headerFile));
		}
	}

	public String getConfiguredHeaderPaths() {
		return headerFilesMetadata.stream()
				.map(HeaderFileMetadata::getHeaderFilePath)
				.collect(Collectors.joining(", "));
	}

	@Override
	public Set<String> getExternalResourceLocations() {
		return headerFilesMetadata.stream()
				.map(HeaderFileMetadata::getHeaderFileUri)
				.map(URI::toASCIIString)
				.collect(Collectors.toUnmodifiableSet());
	}


	@Override
	protected void processFiltered(File file, FileText fileText) {
		if (!headerFilesMetadata.isEmpty()) {
			final List<MatchResult> matchResult = headerFilesMetadata.stream()
					.map(headerFile -> matchHeader(fileText, headerFile))
					.collect(Collectors.toUnmodifiableList());

			if (matchResult.stream().noneMatch(match -> match.isMatching)) {
				final MatchResult mismatch = matchResult.get(0);
				final String allConfiguredHeaderPaths = getConfiguredHeaderPaths();
				log(mismatch.lineNumber, mismatch.messageKey,
						mismatch.messageArg, allConfiguredHeaderPaths);
			}
		}
	}

	private static MatchResult matchHeader(FileText fileText, HeaderFileMetadata headerFile) {
		final int fileSize = fileText.size();
		final List<Pattern> headerPatterns = headerFile.getHeaderPatterns();
		final int headerPatternSize = headerPatterns.size();

		int mismatchLine = MISMATCH_CODE;
		int index;
		for (index = 0; index < headerPatternSize && index < fileSize; index++) {
			if (!headerPatterns.get(index).matcher(fileText.get(index)).find()) {
				mismatchLine = index;
				break;
			}
		}
		if (index < headerPatternSize) {
			mismatchLine = index;
		}

		final MatchResult matchResult;
		if (mismatchLine == MISMATCH_CODE) {
			matchResult = MatchResult.matching();
		}
		else {
			matchResult = createMismatchResult(headerFile, fileText, mismatchLine);
		}
		return matchResult;
	}

	private static MatchResult createMismatchResult(HeaderFileMetadata headerFile,
													FileText fileText, int mismatchLine) {
		final String messageKey;
		final int lineToLog;
		final String messageArg;

		if (headerFile.getHeaderPatterns().size() > fileText.size()) {
			messageKey = MSG_HEADER_MISSING;
			lineToLog = 1;
			messageArg = headerFile.getHeaderFilePath();
		}
		else {
			messageKey = MSG_HEADER_MISMATCH;
			lineToLog = mismatchLine + 1;
			final String lineContent = headerFile.getLineContents().get(mismatchLine);
			if (lineContent.isEmpty()) {
				messageArg = EMPTY_LINE_PATTERN;
			}
			else {
				messageArg = lineContent;
			}
		}
		return MatchResult.mismatch(lineToLog, messageKey, messageArg);
	}

	public static List<String> getLines(String headerFile, URI uri) {
		final List<String> readerLines = new ArrayList<>();
		try (LineNumberReader lineReader = new LineNumberReader(
				new InputStreamReader(
						new BufferedInputStream(uri.toURL().openStream()),
						StandardCharsets.UTF_8)
		)) {
			String line;
			do {
				line = lineReader.readLine();
				if (line != null) {
					readerLines.add(line);
				}
			} while (line != null);
		}
		catch (final IOException exc) {
			throw new IllegalArgumentException("unable to load header file " + headerFile, exc);
		}

		if (readerLines.isEmpty()) {
			throw new IllegalArgumentException("Header file is empty: " + headerFile);
		}
		return readerLines;
	}

	public static HeaderFileMetadata createFromFile(String headerPath) {
		if (CommonUtil.isBlank(headerPath)) {
			throw new IllegalArgumentException("Header file is not set");
		}
		try {
			final URI uri = CommonUtil.getUriByFilename(headerPath);
			final List<String> readerLines = getLines(headerPath, uri);
			final List<Pattern> patterns = readerLines.stream()
					.map(HeaderFileMetadata::createPatternFromLine)
					.collect(Collectors.toUnmodifiableList());
			return new HeaderFileMetadata(uri, headerPath, patterns, readerLines);
		}
		catch (CheckstyleException exc) {
			throw new IllegalArgumentException(
					"Error reading or corrupted header file: " + headerPath, exc);
		}
	}

	private static Pattern createPatternFromLine(String line) {
		final Pattern result;
		if (line.isEmpty()) {
			result = BLANK_LINE;
		}
		else {
			result = Pattern.compile(validateRegex(line));
		}
		return result;
	}

	private static String validateRegex(String input) {
		try {
			Pattern.compile(input);
			return input;
		}
		catch (final PatternSyntaxException exc) {
			throw new IllegalArgumentException("Invalid regex pattern: " + input, exc);
		}
	}

}