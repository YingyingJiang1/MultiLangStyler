public static void printPairs(int[] arr1, int[] arr2) {
	int sum = 0;
	int i = 0; while ( i < arr1.length) { int j = 0; while ( j < arr2.length) { System.out.println("(" + arr1[i] + ", " + arr2[j] + ")");
		j++;} int j1 = i + 2;
		sum += arr1[i] + arr2[j1];
	i++;} }
