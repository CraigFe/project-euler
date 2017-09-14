package solutions;

import java.math.BigInteger;


public final class p037 implements Solution {
	
	@Override
	public String run() {
		long startTime = System.nanoTime();
		int counter = 0;
		int sum = 0;
		
		//2,3,5,7 not considered truncatable
		for (int i = 10; counter < 11; i++) {
			if (isTruncatablePrime(i)) {
				System.out.println(i);
				counter++;
				sum+=i;
			}
		}
		
		return Integer.toString(run);
	}
	
	public static boolean isTruncatablePrime(int p) {
		String a = " " + String.valueOf(p);
		String b = String.valueOf(p) + " ";
		BigInteger left = BigInteger.ZERO;
		BigInteger right = BigInteger.ZERO;
		
		do {
			a = a.substring(1);
			left = new BigInteger(a);
			if (!left.isProbablePrime(15)) return false;
			
			b = b.substring(0, b.length()-1);
			right = new BigInteger(b);
			if (!right.isProbablePrime(15)) return false;
			
		} while (a.length() > 1);
		return true;
	}
}