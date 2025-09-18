public class BraceExample {
	public static void main(String[] args) {
		int x = 5;
		int y = 10;
		int sum = 0;



		if (x > 0) 
			sum += x;
		else 
			sum += y;

		if (x < 0) 
			x++;
		else if (x == 0) 
			x += 2;
		else 
			x += 3;

		while (x < 10) 
			x++;

		for (int i = 0; i < 5; i++) 
			sum += i;

		do 
			sum--;
		while (sum > 0);

		if (sum > 5) {
			if (x > y) 
				sum = x;
			else 
				sum = y;
		}

		if (x == y) 
			sum++;
		else 
			sum--;

		for (int i = 0; i < 3; i++) {
			if (i % 2 == 0) 
				continue;
			else 
				sum += i;
		}

		int result = 0;
		if (sum > 0) 
			result = sum;
		else 
			result = -sum;

		System.out.println(result);
	}
}
