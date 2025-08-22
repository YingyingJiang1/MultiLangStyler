public static void printPairs(int[] arr1, int[] arr2) {
	int sum = 0;
	for (int i = 0; i < arr1.length; i++) {
		for (int j = 0; j < arr2.length; j++) {
			System.out.println("(" + arr1[i] + ", " + arr2[j] + ")");
		}

		int j = i + 2;
		sum += arr1[i] + arr2[j];
	}
}
