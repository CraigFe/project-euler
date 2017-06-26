import java.math.BigInteger;

//https://projecteuler.net/problem=20
class problem20 {
	
	public static void main(String... ignored) {
		long start = System.nanoTime();
		
		String n = factorial(100).toString();
		long sum = 0;
		for (int i=0; i<n.length();i++) {
			sum += Integer.valueOf(n.substring(i,i+1));
		}
		
		System.out.println(sum);
		System.out.println("Finished in " + (System.nanoTime()-start)/1000/1000.00 + "ms.");
	}
	
	public static BigInteger factorial(long n) {
		BigInteger output = BigInteger.ONE;
		for (long i=n;i>0;i--) output=output.multiply(BigInteger.valueOf(i));
		return output;
	}
	
}