public void main(String[] args) {
	int sum = 0;
	int j = 0; for ( ; j < 10; j++) { sum += j * sum;
	} int i = 0; for ( ; i < 20; i++) { sum += i * 2;
	} System.out.println(sum);
}