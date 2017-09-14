package solutions;

/**
 * What is the 10,001st prime number?
 * https://projecteuler.net/problem=7
 * 
 * @author cf443
 */

public final class p007 implements Solution {
	
	/*
	 * We could use a sieve of Eratosthenes to lazily build a set of primes until
	 * it includes 10,001 elements, but it is simpler to iterate through the
	 * numbers and test if each one is a prime
	 */
	@Override
	public String run() {
		
		int count = 0; //Accumulator
		
		for (int i = 2; ; i++) {
			if (isPrime(i)) {
				count++;
				if (count == 10001) return Integer.toString(i);
			}
		}
		
	}
	
	//Test if an integer is prime by simple iteration through possible factors
	private static boolean isPrime(int n) {
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
}