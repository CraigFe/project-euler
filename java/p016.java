import java.math.BigInteger;

/**
 * What is the sum of the digits of the number 2^1000?
 * 
 * @author cf443
 */
public final class p016 implements Solution {
	
	/*
	 * The solution is straightforward using the BigInteger library. Simply
	 * calculate the value of 2^1000 and calculate the sum of the digits via
	 * iteration.
	 */
	@Override
	public String run() {
		
		String tmp = BigInteger.ONE.shiftLeft(1000).toString();
		int dsum = 0;
		
		for (int i = 0; i < tmp.length(); i++) {
			dsum += tmp.charAt(i) - '0';
		}
			
		return Integer.toString(dsum);
	}
	
}