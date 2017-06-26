import java.math.BigInteger;

//https://projecteuler.net/problem=3
public final class p003 implements Solution {
	
	/*
	 * Given a composite number n > 1, it can be uniquely represented as the
	 * product of prime numbers (by the Fundamental Theorem of Arithmetic).
	 * By repetedly dividing n by its smallest factor, the last factor to be
	 * divided out must be the largest prime factor of n.
	 */
	public String run() {
		long n = 600851475143L;
		while (true) {
			long p = getSmallestFactor(n);
			if (p < n) n /= p;
			else return Long.toString(n);
		}
	}
	
	//Returns the smallest factor of n
	private static long smallestFactor(long n) {
		if (n <= 1) throw new IllegalArgumentException();
		
		for (long i = 2, end = Library.sqrt(n); i <= end; i++) {
			if (n % i == 0) return i;
		}
		
		return n; //n is a prime
	}	
}