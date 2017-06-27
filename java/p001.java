/**
 * Calculate the sum of all multiples of 3 and 5 less than 1000
 * https://projecteuler.net/problem=1
 * 
 * @author cf443
 */

public final class p001 implements Solution {
	
	/*
	 * Simply runs a brute force search for multiples of 3 or 5 and adds them
	 * to an accumulator
	 */
	@Override
	public String run() {
		
		int sum = 0; //Accumulator
		
		for (int i = 1; i < 1000; i++) {
			if (i%3 == 0 || i%5 == 0) sum += i;
		}
		
		return Integer.toString(sum);
	}
	
	
}