package org.example;

public class ReferenceCodeStorage {
	private static ReferenceCodeStorage instance = new ReferenceCodeStorage();
	private String referenceCode = null;

	private ReferenceCodeStorage() {}

	public static ReferenceCodeStorage getInstance() {
		return instance;
	}

	public void setReferenceCode(String referenceCode) {
		this.referenceCode = referenceCode;
	}

	public String getReferenceCode() {
		return referenceCode;
	}

	public boolean hasReferenceCode() {
		return referenceCode != null;
	}

	public void clear() {
		referenceCode = null;
	}
}
