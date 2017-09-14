package solutions;

import java.math.BigInteger;

/**
 * Find the sum of the digits in the number 100!
 * https://projecteuler.net/problem=20
 * 
 * @author cf443
 */
public final class p020 implements Solution {
	
	/*
	 * Simply calculate the value of 100! using the BigInteger library and then compute the sum of
	 * its digits iteratively.
	 */
	public String run() {
		String n = factorial(100).toString();
		int sum = 0;
		for (int i = 0; i < n.length(); i++) {
			sum += n.charAt(i) - '0';
		}
		
		return Integer.toString(sum);
	}
	
	//Factorial by iteration
	public static BigInteger factorial(long n) {
		BigInteger output = BigInteger.ONE;
		for (long i=n;i>0;i--) output=output.multiply(BigInteger.valueOf(i));
		return output;
	}
	
}