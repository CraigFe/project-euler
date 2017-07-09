/**
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * https://projecteuler.net/problem=34
 * 
 * @author cf443
 */
public final class p034 implements Solution {
	
	/* The solution can be simply solved by simply brute-forcing through the range of numbers
	 * for which it is possible for a number to equal the sum of factorials of its digits. If
	 * a number n has d >= 8 digits, then even in the maximal case of all digits being 9:
	 * 		d * 9! < 10^d <= n
	 * 
	 * Thus, only numbers with 7 digits or less are possible solutions. The maximum number
	 * achievable with 7 digits is 7*9!, so this is a reasonable upper bound for calculations.
	 * 
	 * 1 = 1! and 2 = 2! are excluded as they are not sums.
	 */
	@Override
	public String run() {

		int total = 0; //Accumulator
		
		//7*9! = 2540160
		for (int n = 10; n <= 2540160; n++) {
			int tmp = n; //Temporary value to perform destructive calculations on the loop counter
			int sum = 0; //Running sum of the factorials of the digits
			
			while (tmp != 0) {
				sum += facts[tmp % 10];
				tmp /= 10;
			}
			if (n == sum) total+=n;
		}
		return Integer.toString(total);
	}

	// Hard-coded values for 0!, 1!, ..., 9!
	private static int[] facts = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
}