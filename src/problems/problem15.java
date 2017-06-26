import java.math.BigInteger;

//https://projecteuler.net/problem=15
class problem15 {
	
	/* Recursive definition of nCr - WORKING - 1000C500 in 5.158ms*/
	public static void main(String... ignored) {
		long start = System.nanoTime();
		System.out.println(nCr(1000,500));
		System.out.println("Finished in " + (System.nanoTime()-start)/1000/1000.00 + "ms.");
	}
	
	//nC(r+1) = nCr * (n-r)/(r+1)
	//nCr = nC(r-1) * (n+1-r)/r
	public static BigInteger nCr(int n, int r) {
		if (r == 0) return BigInteger.ONE;
		return nCr(n,r-1).multiply(BigInteger.valueOf(n+1-r)).divide(BigInteger.valueOf(r));
		//N.B. Calculate numerator first to avoid fractions
	}
	
	// Recursive factorial - WORKING - 1000C500 in 9.721ms
	public static void main2(String... ignored) {

		long start = System.nanoTime();
		int gridSize = 500;
		System.out.println(nCr(2*gridSize,gridSize));
		System.out.println("Finished in " + (System.nanoTime()-start)/1000/1000.00 + "ms.");
	}
	
	public static BigInteger factorial(long n) {
		if (n==1) return BigInteger.ONE;
		return factorial(n-1).multiply(BigInteger.valueOf(n));
	}
	
	public static BigInteger nCr(long n, long r) {
		return factorial(n).divide(factorial(r).multiply(factorial(n-r)));
	}
}