
/**
 * https://projecteuler.net/problem=4
 * 
 * @author cf443
 *
 */

public final class p004 implements Solution {
	
	@Override
	public String run() {
		int largest = 0;
		

		for (int i = 100; i < 1000; i++) {
			for (int j = i; j < 1000; j++) {
				if (isPalindrome(i*j)) largest = (i*j > largest) ? i*j : largest;
			}
		}
		return Integer.toString(largest);
	}
	
	//Tests if an integer is a palindrome (is invariant under swapping the digits)
	private static boolean isPalindrome(int input) {
		String n = String.valueOf(input);
		
		for (int i = 0; i <= n.length()/2; i++) {
			if (n.charAt(i) != n.charAt(n.length() - 1 - i)) return false;
		}
		return true;
	}
}