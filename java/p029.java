import java.util.HashSet;
import java.util.Set;

/**
 * How many distinct terms are in the sequence given by a^b for 2 <= a <= 100 and 2 <= b <= 100?
 * https://projecteuler.net/problem=29
 * 
 * @author cf443
 */
public final class p029 implements Solution {
	
	/*
	 * We simply generate all possible values of a^b for a,b in the range [2,100] and add these
	 * values to a set. Then return the size of the set once all values have been calculated. 
	 * 
	 * The use of a set handles duplicate values automatically.
	 */
	@Override
	public String run() {
		Set<Double> results = new HashSet<>();
		
		for (int a = 2; a <= 100; a++) {
			for (int b = 2; b <= 100; b++) {
				results.add(Math.pow(a, b));
			}
		}
		
		return Integer.toString(results.size());
	}
}