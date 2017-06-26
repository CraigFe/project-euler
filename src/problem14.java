import static java.lang.System.out;

import java.util.LinkedList;

//https://projecteuler.net/problem=14
class problem14 {
	
	//Cached method
	static final short[] cache = new short[1000000];
	
	static {
		for (int i = 10; i < cache.length; i *= 2)
			collatzNum(i - 1);
	}
	
	public static void main(String... ignored) {
		long begin = System.nanoTime();
		int maxCount = 0, max = 0;
		for (int i = 1; i < 1000000; i++) {
			int count = collatzNum(i);
			if (count > maxCount) {
				maxCount  = count;
				max = i;
			}
		}
		long time = System.nanoTime() - begin;
		System.out.println("count=" + maxCount + ", value=" + max + ", took=" + time / 1000 / 1000.00 + " ms.");
	}
	
	public static int collatzNum(long n) {
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
	
	// Non cached method - WORKING ~2652ms
	public static void main2() {
		long begin = System.currentTimeMillis();
		
		LinkedList<Long> list = new LinkedList<Long>();
		long length = 0;
		int res = 0;
		
		for (int i = 10; i < 1000000; i++) {
			
			long j = i;
			while (j != 1) {
				if (j%2==0) {
					j/=2;
					list.add((long) i);
				}
				else {
					j = (3*j) + 1;
					list.add((long) j);
				}
			}
			if (list.size() > length) {
				length = list.size();
				res=i;
				out.println("New max ("+res+") of chain size:"+length);
			}
			list.clear();
		}
		long end = System.currentTimeMillis();
		out.println(res+" with chain size: "+length);
		out.println(end-begin+"ms");
	} 
}