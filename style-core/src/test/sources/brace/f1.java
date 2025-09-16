public void setHeaderFiles(String... headerFiles) {
	final String[] files;
	if (headerFiles == null) {

	}


	headerFilesMetadata.clear();

	for (final String headerFile : files) {
		headerFilesMetadata.add(HeaderFileMetadata.createFromFile(headerFile));
	}
}