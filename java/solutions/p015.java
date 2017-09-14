package solutions; /**
 * Starting in the top left corner of a 20x20 grid, and only being able to move to the right and
 * down, how many routes are there?
 * 
 * @author cf443
 */

import java.math.BigInteger;

public final class p015 implements Solution {

	/*
	 * This problem is easily solved by combinatorics. Travelling from the top-left corner to the
	 * bottom-right corner of an N*N grid can be interpreted as a series of 2N choices of whether
	 * to go downwards or rightwards. In total there must be 20 'right' choices, and 20 'down'
	 * choices, and it does not matter in which order they appear. The number of ways of selecting
	 * a combination of 20 elements from a set of 40 is given by choose(20,40), which is computed
	 * here using a multiplicative formula.
	 */
	public String run() {
		return nCr(40,20).toString();
	}
	
	/*
	 * Multiplicative formula for calculating nCr:
	 * 	nCr(n, r) = product from i=1 to r of (n+1-i)/i
	 */
	public static BigInteger nCr(int n, int r) {
		BigInteger prod = BigInteger.ONE;
		
		//Numerator
		for (int i = 0; i < r; i++) prod = prod.multiply(BigInteger.valueOf(n - i));
	
		//Denominator
		for (int i = 2; i <= r; i++) prod = prod.divide(BigInteger.valueOf(i));
		
		return prod;
	}
}