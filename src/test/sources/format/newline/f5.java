public void setJdkVersion(String jdkVersion) {
	final String singleVersionNumber;
	if
	(jdkVersion.startsWith("1.")) {
		singleVersionNumber = jdkVersion.substring(2);
	} else {
		singleVersionNumber = jdkVersion;
	}

	this.jdkVersion = Integer.parseInt(singleVersionNumber);
}
