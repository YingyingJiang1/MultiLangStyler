public static void main(String[] args) {
	if (i == 2 || i == 3) {
		boolean found = IntStream.range(0, 5).anyMatch(i -> {
			if (i == 2) {
				return true;
			}
			return false;
		});
	}

	if ( a > b) {
		return false;
	}
if ( a + b < 50) {
		return false;
	}
}