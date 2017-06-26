import java.math.BigInteger;

//https://projecteuler.net/problem=16
class problem16 {
	
	public static void main(String... ignored) {
		long start = System.nanoTime();

		BigInteger x = BigInteger.valueOf(2).pow(1000);
		int dsum = 0;
		
		while (!x.equals(BigInteger.ZERO)) {
			dsum += x.mod(BigInteger.TEN).intValue();
			x = x.divide(BigInteger.TEN);
		}
			
		System.out.println(dsum);
		System.out.println("Finished in " + (System.nanoTime()-start)/1000/1000.00 + "ms.");
	}
	
}