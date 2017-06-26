import java.math.BigInteger;

//https://projecteuler.net/problem=3
class Problem03 extends Solution {
	
	//A lazy solution using BigInteger.nextProbablePrime()
	String strat_bigInteger() {
		BigInteger composite = BigInteger.valueOf(600851475143L);
		BigInteger prime = BigInteger.ONE;
		BigInteger largest = prime;
		
		while (prime.compareTo(composite) == -1) {
			if (composite.mod(prime) == BigInteger.ZERO) largest = prime;
			prime = prime.nextProbablePrime();
		}	
		return largest.toString();
	}
	
	//Standard Eratosthenes seive
	
	//Functional Eratosthenes seive
	
	
}