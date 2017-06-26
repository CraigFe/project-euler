import java.math.BigInteger;

class problem25 {
	public static void main(String... ignored) {
		long startTime = System.nanoTime();
		
		BigInteger[] fibs = new BigInteger[3];
		fibs[1] = BigInteger.ONE;
		fibs[2] = BigInteger.ONE;
		
		int digits = 0, nth = 1000, n = 3; //Initial values
		for (; digits != nth; n++) {
			fibs[0] = fibs[1];
			fibs[1] = fibs[2];
			fibs[2] = fibs[1].add(fibs[0]);
			digits = fibs[2].toString().length();
			System.out.println("n: "+n+" - digits: "+digits+" - fib: "+fibs[2]);
		}
		System.out.println(n--);
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
}
