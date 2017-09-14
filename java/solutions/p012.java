package solutions;

/**
 * What is the value of the first triangular number to have over five hundred divisors?
 * https://projecteuler.net/problem=12
 * 
 * @author cf443
 */
public final class p012 implements Solution {
	
	/*
	 * A simple brute-force solution which counts the number of divisors for each of the
	 * triangular numbers until one is found which has more than 500 divisors 
	 */
	@Override
	public String run() {
		int divs = 0,
			max = 0; //Maximum divs
		
		long tri = 0; //current triangular number
		
		for (int n = 1; divs < 500; n++) {
			tri += n; //Triangle is the ith triangular number
			
			divs = noDivisors(tri);
			if (divs > max) max = divs;
		}
		
		return Long.toString(tri);
	}
	
	//Calculates the number of divisors of a number by trying all of them
	public static int noDivisors(long n) {
		int divs = 0; //Account for n%n=0
		for (double i = 1; i <= Math.sqrt(n); i++) {
			if (n%i==0) divs+=2;
			if (Math.sqrt(n)%1==0) divs--; //Account for square numbers
		}
		return divs;
	}
}