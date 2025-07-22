	private static String normalizeArch(String value) {
		value = normalize(value);
		if (value.matches("^(x8664|amd64|ia32e|em64t|x64)$")) {
			return "x86_64";
		}
		if (value.matches("^(x8632|x86|i[3-6]86|ia32|x32)$")) {
			return "x86_32";
		}
		if (value.matches("^(ia64w?|itanium64)$")) {
			return "itanium_64";
		}
		if ("ia64n".equals(value)) {
			return "itanium_32";
		}
		if (value.matches("^(sparc|sparc32)$")) {
			return "sparc_32";
		}
		if (value.matches("^(sparcv9|sparc64)$")) {
			return "sparc_64";
		}
		if (value.matches("^(arm|arm32)$")) {
			return "arm_32";
		}
		if ("aarch64".equals(value)) {
			return "aarch_64";
		}
		if (value.matches("^(mips|mips32)$")) {
			return "mips_32";
		}
		if (value.matches("^(mipsel|mips32el)$")) {
			return "mipsel_32";
		}
		if ("mips64".equals(value)) {
			return "mips_64";
		}
		if ("mips64el".equals(value)) {
			return "mipsel_64";
		}
		if (value.matches("^(ppc|ppc32)$")) {
			return "ppc_32";
		}
		if (value.matches("^(ppcle|ppc32le)$")) {
			return "ppcle_32";
		}
		if ("ppc64".equals(value)) {
			return "ppc_64";
		}
		if ("ppc64le".equals(value)) {
			return "ppcle_64";
		}
		if ("s390".equals(value)) {
			return "s390_32";
		}
		if ("s390x".equals(value)) {
			return "s390_64";
		}
		return value;
	}
