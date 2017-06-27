/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n). If d(a) = b and d(b) = a, where a != b, then a 
 * and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 * 
 * @author cf443
 */

public final class p021 implements Solution {
	
	/*
	 * Iterate through all of the integers less than 1e4 and test whether
	 * each once is amicable using the definition by brute force, keeping
	 * an accumulator.
	 */
	public String run() {

		long sum = 0, //Accumulator 
			 a = 0, 
			 b = 0;
		
		//Iterate through all of the integers less than 1e4
		for (int i = 1; i < 10000; i++) {
			a = divisors(i);
			b = divisors(a);
			
			if (i==b && a!=b) sum+=a+b; //Add both numbers to the accumulator
		}
		
		return Long.toString(sum/2); //Halve to account for double-counting
		
	}
	
	//The sum of proper divisors of long n
	private static long divisors(long n) {
		
		int sum = 0;
		for (double i = 1; i <= Math.sqrt(n); i++) {
			if (n%i==0) {
				sum += i;
				sum += n/i;
			}
			if (Math.sqrt(n)%1==0) sum -= i; //Account for square numbers
		}
		return sum-n; //Account for n%n=0 (proper divisors)
	}
}