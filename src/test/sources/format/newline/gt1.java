importjava.util.Scanner;publicclassPrimeCounter{
	// Function to check if a number is prime
	// Function to check if a number is prime
	publicstaticbooleanisPrime(longn){
		// If number is less than 2, it's not prime
		// If number is less than 2, it's not prime
		if(n<2)returnfalse;// Check for divisibility up to square root of n
		// Check for divisibility up to square root of n
		for(longi=2;i*i<=n;i++){
			if(n%i==0){returnfalse;}}
		returntrue;}
	publicstaticvoidmain(String[]args){
		Scannerscanner=newScanner(System.in);// Read the number of elements
		// Read the number of elements
		intN=scanner.nextInt();// Counter for prime numbers
		// Counter for prime numbers
		intprimeCount=0;// Read N numbers and count primes
		// Read N numbers and count primes
		for(inti=0;i<N;i++){
			longnum=scanner.nextLong();if(isPrime(num)){primeCount++;}}
		// Print the result
		// Print the result
		System.out.println(primeCount);scanner.close();}
}
