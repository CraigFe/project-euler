package solutions;

import java.util.stream.IntStream;

/**
 * Calculate the sum of all multiples of 3 and 5 less than 1000
 * https://projecteuler.net/problem=1
 * 
 * @author cf443
 */
public final class p001 implements Solution {
	
	/*
	 * Simply runs a brute force search for multiples of 3 or 5 and adds them
	 * to an accumulator
	 */
	@Override
	public String run() {
        return String.valueOf(IntStream.iterate(1, i -> i + 1)
                .limit(999)
                .filter(i -> i % 3 == 0 || i % 5 == 0)
                .sum());
	}

}