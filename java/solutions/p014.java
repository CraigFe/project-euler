package solutions;//https://projecteuler.net/problem=14


public final class p014 implements Solution {
	
	
	@Override
	public String run() {
		
		int maxCount = 0, max = 0;
		for (int i = 1; i < 1000000; i++) {
			int count = collatzNum(i);
			if (count > maxCount) {
				maxCount  = count;
				max = i;
			}
		}
		return "count=" + maxCount + ", value=" + max;
	}
	
	//Initialise the cache	
	static final short[] cache = new short[1000000];
	static {
		for (int i = 10; i < cache.length; i *= 2) collatzNum(i - 1);
	}
		
	//Compute the nth Collatz sequence length
	private static int collatzNum(long n) {
		if (n == 1) return 1;
		if (n < cache.length) {
			int count = cache[((int) n)];
			if (count > 0) return count;
		}
		int next = (n&1) == 0
				? 1 + collatzNum(n>>1)
				: 2 + collatzNum((n*3+1) >> 1);
		if (n < cache.length) 
			cache[((int) n)] = (short) next;
		return next;
	}
}