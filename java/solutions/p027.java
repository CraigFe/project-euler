package solutions;

import java.math.BigInteger;

class problem27 {
	
	//Lazy brute force
	public static void main(String... ignored) {
		long startTime = System.nanoTime();
		int max = 0, alpha = 0, beta = 0;
		
		for (int a = -1000; a <= 1000; a++) {
			for (int b = -1000; b <= 1000; b++) {
				int n=0;
				while (quad(n,a,b).isProbablePrime(10)) n++;
				if (n > max) {
					max = n;
					alpha = a;
					beta = b;
				}
			}
		}
		
		System.out.println(alpha*beta);
		
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
	
	public static BigInteger quad(int n, int a, int b) {
		return BigInteger.valueOf(n*n + n*a + b);
	}
	

}