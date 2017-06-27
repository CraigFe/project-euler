/**
 * 
 * https://projecteuler.net/problem=5
 * 
 * @author cf443
 */

public final class p005 implements Solution {
	
	@Override
	public String run() {
		int n = 1;
		for (int i = 2; i <= 20; i++) n = lcm(n,i);
		return Integer.toString(n);
	}
	
	//Returns the greatest common denominator of two integers
	private static int gcd(int a, int b) {
		if (b==0) return a;
		return gcd(b,a%b);
	}
	
	//Returns the lowest common multiple of two integers
	private static int lcm(int a, int b) {
		return a/gcd(a,b) * b;
	}
}