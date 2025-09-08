public static boolean checkRotation(String S, String T) {
	// If lengths are different, rotation is impossible
	if (S.length() != T.length()) {
		return false;
	}
	// If T is a substring of doubledS, then T is a rotation of S
	return doubledS.contains(T);
}