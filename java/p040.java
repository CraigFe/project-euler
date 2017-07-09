import java.lang.Math;

/** Champernowne's constant is an irrational decimal fraction obtained by concatenating the
 * positive integers: 
 *	0.12345678910111213...
 *
 * Find the product of the nth digits where n = 1e0, 1e1 ..., 1e6
 * https://projecteuler.net/problem=40
 * 
 * @author cf443
 */
public final class p040 implements Solution {
	
	/*
	 * A simple brute-force solution which generates 1e6 digits of Champernowne's constant and then
	 * calculates the product of the appropriate digits. Some small amout of efficiency is achieved
	 * by using the StringBuilder class instead of repeatedly using the concatenation operator (+),
	 * which creates a new String object in every statement it is used and is therefore costly.
	 */
	@Override
	public String run() {
		StringBuilder sb = new StringBuilder();
		for(int i = 1; sb.length() < 1000000; i++) sb.append(i);
		
		int product = 1;
		for(int k = 0; k <= 6; k++) product *= sb.charAt((int) (Math.pow(10, k) - 1)) - '0';

		return Integer.toString(product);
	}
}