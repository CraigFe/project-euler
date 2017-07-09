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
	 * for large n.
	 */
	@Override
	public String run() {
		
		BigInteger[] fibs = {BigInteger.ONE, BigInteger.ONE, BigInteger.ONE};
		BigInteger bound = BigInteger.TEN.pow(1000); //The smallest number with 1000 digits
		
		int n;
		for (n = 3; bound.compareTo(fibs[2]) > 0; n++) {
			fibs[0] = fibs[1];
			fibs[1] = fibs[2];
			fibs[2] = fibs[1].add(fibs[0]);
		}
		return Integer.toString(n);
	}
}
