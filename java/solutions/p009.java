package solutions;

/**
 * Find the Pythagorean triplet for which perimeter = 1000
 * https://projecteuler.net/problem=9
 * 
 * @author cf443
 */

public final class p009 implements Solution {

	/*
	 * Given that a < b, simply iterate through all possible values of
	 */
	@Override
	public String run() {
		
		int a=0, 
		    b=1, 
		    p=1000; //Perimeter, set at 1000

		for (; b < 500; b++) {
			if ((500000-p*b)%(p-b) == 0) {
				a = (500000-p*b)/(p-b);
				break;
			}
		}
		int c = (int) Math.sqrt(a*a + b*b);
		
		return Integer.toString(a*b*c);
	}
	
}
