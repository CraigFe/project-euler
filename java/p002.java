/**
 * Calculate the sum of all even Fibonacci numbers less than 4,000,000
 * https://projecteuler.net/problem=2
 * 
 * @author cf443
 */

public final class p002 implements Solution {
	
	/*
	 * A simple brute-force loop which generates all Fibonacci numbers less
	 * than 4,000,000 and adds the even numbers to an accumulator.
	 */
	@Override
	public String run() {
	
		int sum = 2;		 //Accumulator
		int[] fib = {1,2,0}; //Current Fibonacci terms
		
		while(true) {
			fib[2] = fib[1] + fib[0];
			
			if (fib[2] > 4000000) break;
			if (fib[2] % 2 == 0) sum += fib[2]; //Even found
			
			//Reallocate temporary variables
			fib[0] = fib[1];
			fib[1] = fib[2];
		}
		
		 return Integer.toString(sum);
	}
}