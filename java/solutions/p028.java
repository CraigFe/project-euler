package solutions;

/**
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is 
 * formed as follows:
 *
 *		21 22 23 24 25
 *		20  7  8  9 10
 *		19  6  1  2 11
 *		18  5  4  3 12
 *		17 16 15 14 13
 *
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 * https://projecteuler.net/problem=28
 * 
 * @author cf443
 */
public final class p028 implements Solution {
	
	/*
	 * Given an n*n grid of numbers, consider the sum of the four corner elements. The top-right
	 * corner has the value n^2. Working backwards along the spiral, the top-left corner has the
	 * value n^2 - (n - 1), the bottom-left corner has the value n^2 - 2(n - 1), and the bottom
	 * right has the value n^2 - 3(n - 1). Thus, the outermost ring contributes 4n^2 - 6(n - 1)
	 * to the sum of the elements on its diagonals.
	 * 
	 * Using simple summation formula for polynomials, a closed form for this sum is given by: 
	 * 	sum(n) = (4n^3 + 3n^2 + 8n - 9) / 6
	 * 
	 * The solution simply calculates the value of this polynomial for n=1001
	 */
	@Override
	public String run() {
		Long ans = (4l*1001*1001*1001 + 3*1001*1001 + 8*1001 - 9) / 6;
		return Long.toString(ans);
	}
}