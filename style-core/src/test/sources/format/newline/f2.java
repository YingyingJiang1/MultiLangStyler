import java.util.Scanner;

	public class PrimeCounter {
		// Function to check if a number is prime
		public static boolean isPrime(long n) {
			// If number is less than 2, it's not prime
			if (n < 2) return false;

			// Check for divisibility up to square root of n
			for (long i = 2; i * i <= n; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			return true;
		}

		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);

			// Read the number of elements
			int N = scanner.nextInt();

			// Counter for prime numbers
			int primeCount = 0;

			// Read N numbers and count primes
			for (int i = 0; i < N; i++) {
				long num = scanner.nextLong();
				if (isPrime(num)) {
					primeCount++;
				} else {
					System.out.println(primeCount);
				}
			}

			// Print the result
			System.out.println(primeCount);

			scanner.close();
		}
	}