/**
 * Calculate the sum of all multiples of 3 and 5 less than 1000
 * https://projecteuler.net/problem=1
 * 
 * @author cf443
 */
class Problem01 extends Solution {
	
	//Brute force loop
	int strat_bruteForce() {
		
		int sum = 0; //Accumulator
		
		for (int i = 1; i < 1000; i++) {
			if (i%3 == 0 || i%5 == 0) sum += i;
		}
		
		return sum;
	}
	
	//Pair multiples into equal results and multiply
	int strat_pairwiseSum() {
		
		// (3 + 999, 6 + 996, 9 + 993...) + 5 + 995, 10 + 990, 15 + 
		return 1020; //TODO
	
	}
	
}