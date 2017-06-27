/**
 * Find the sum of all the primes below two million.
 * https://projecteuler.net/problem=10
 * 
 * @author cf443
 */
public final class p010 implements Solution {
	
	/*
	 * Use a sieve of Eratosthenes to generate a boolean array of primalities,
	 * then iterate through this array, summing the indices of all true values.
	 */
	@Override
	public String run() {
		
		boolean[] isPrime = getPrimalities(2000000); //Run the sieve up to 2e6
		int sum = 2; //Accumulator
		
		for (int i = 3; i < 2000000; i += 2) {
			if (isPrime[i]) sum += i;
		}
		
		return Integer.toString(sum);
	}
	
	/*
	 * Generates a boolean array of size n+1, where the element at index i is
	 * true if and only if i is prime. Uses a sieve of Eratosthenes.
	 */
	private static boolean[] getPrimalities(int n) {
		boolean[] isPrime = new boolean[n + 1]; //An array 
		
		//Sieve of Eratosthenes
		int end = (int) Math.sqrt(n);
		for (int i = 2; i <= end; i += 2) {
			
			//Eliminate all multiples of the prime within the array
			if (isPrime[i]) {
				for (int j = i*i; j <= n; j += 2*i) {
					isPrime[j] = false;
				}
			}
			
		}
		
		return isPrime;
	}
}