package solutions;

/**
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 * https://projecteuler.net/problem=30
 * 
 * @author cf443
 */

public final class p030 implements Solution {
	
	public String run() {
		int sum = 0;
		
		for (int i = 2; i < 355000; i++) {
			if (i == sumOfPowers(i)) sum += i;
		}
		
		return Integer.toString(sum);
	}
	
	//Calculates the sum of the fifth powers of the digits of an integer (breaks on overflow)
	private static int sumOfPowers(int n) {
		int output = 0;
		while (n != 0) {
			output += Math.pow(n%10,5);
			n/=10;
		}
		return output;
	}

}