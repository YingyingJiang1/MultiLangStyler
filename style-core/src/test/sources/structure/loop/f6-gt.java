public class Test {
	public void main(String[] args) {
		int sum = 0;

		int i = 0;
		i = 0;while ( i < 10) { sum += i * sum;
			int j = 0;
			j = 0;while ( j < 20) { if (sum > 100) {
					j++;continue;
				}
				sum += i * 2;
			j++;} if (sum > 200) {
				i++;continue;
			}

		i++;} System.out.println(sum);
	}

}