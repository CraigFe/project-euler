package solutions;

import java.math.BigInteger;

/**
 * Given fib(1) = 1 and fib(2) = 1, what is the smallest value of n such that fib(n) >= 10^1000?
 * 
 * @author cf443
 */
public final class p025 implements Solution {
	
	/* The Fibonacci numbers fgrow exponentially with a base of ~1.618. Thus, the value of fib(n)
	 * increases by one digit every ~4.78 (log_10(1.618)) on average. The correct answer is thus
	 * at around 4780. We could simply compute the Fibonacci numbers in the standard way and output
	 * the first number which has 1000 digits, but it is cleverer to trust in the accuracy of the
	 * exponential growth of fib(n) for large n and begin scanning integers in the vicinity of 4780
	 * for large n. Here I use a fast algorithm for calculating Fibonacci numbers for large n.
	 */
	@Override
	public String run() {
		
		BigInteger[] fibs = {BigInteger.ONE, BigInteger.ONE, BigInteger.ONE};
		BigInteger bound = BigInteger.TEN.pow(1000); //The smallest number with 1000 digits
		
		//Take a conservative lower bound of the estimate - 10
		int n = 4770;
		while (bound.compareTo(fib(n)) > 0) n++;
		return Integer.toString(n);
	}
	
	/*
	 * Fast Fibonacci doubling, see https://github.com/cf443/coursework
	 * 
	 * Given F(0) = 0, F(1) = 1
	 * 
	 *	F(2n)   = F(n) * (2*F(n+1) - F(n))
	 *  F(2n_1) = F(n+1)^2 + F(n)^2
	 */
	private static BigInteger fib(int n) {
		if (n < 2) return BigInteger.valueOf(n);
		
		if (n % 2 == 0) {
			return fib(n / 2)
					.multiply( (fib(n / 2 + 1).multiply(BigInteger.valueOf(2))
											  .subtract(fib(n))));
		} else {
			return fib(n / 2 + 1).pow(2)
					.add((fib(n / 2).pow(2)));
		}
	}
}
