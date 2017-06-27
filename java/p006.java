/**
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 * https://projecteuler.net/problem=6
 * 
 * @author cf443
 */

public final class p006 implements Solution {

	/*
	 * By expanding (1 + 2 + ... + 100)^2 and subtracting the sum of the 
	 * squares, the terms remaining are the cross terms. These terms all appear
	 * exactly twice, and so the solution is to generate the sum of all of the
	 * cross-terms using nested for loops and then multiply by two.
	 */
	@Override
	public String run() {
		int ans = 0;
		
		for (int i = 1; i < 100; i++) {
			for (int j = i+1; j <= 100; j++) {
				ans+=i*j;
			}
		}
		
		ans*=2;
		return Integer.toString(ans);
	}

}