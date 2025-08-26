public void main(String[] args) {
	int sum = 0;
	for (int i = 0; i < 10; i++) {
		sum += i * sum;
	}

	for (int i = 0; i < 20; i++) {
		sum += i * 2;
	}

	System.out.println(sum);
}