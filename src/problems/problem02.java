
/**
 * Calculate the sum of all even Fibonacci numbers less than 4,000,000
 * https://projecteuler.net/problem=2
 * 
 * @author Craig
 */
//https://projecteuler.net/problem=2
class Problem02 extends Solution {
	
	//Brute force loop
	int strat_bruteForce() {
	
		int sum = 2;		 //Accumulator
		int[] fib = {1,2,0}; //Current Fibonacci terms
		
		while(true) {
			fib[2] = fib[1] + fib[0];
			
			if (fib[2] > 4000000) break;
			if (fib[2] % 2 == 0) sum += fib[2]; //Even found
			
			//Reallocate temporary variables
			fib[0] = fib[1];
			fib[1] = fib[2];
		}
		
		return sum;
	}
}