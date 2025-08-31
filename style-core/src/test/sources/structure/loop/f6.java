public class Test {
	public void main(String[] args) {
		int sum = 0;

		int i = 0;
		for (i = 0; i < 10; i++) {
			sum += i * sum;
			int j = 0;
			for (j = 0; j < 20; j++) {
				if (sum > 100) {
					continue;
				}
				sum += i * 2;
			}

			if (sum > 200) {
				continue;
			}

		}

		System.out.println(sum);
	}

}