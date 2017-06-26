import java.math.BigInteger;

class problem48 {
	public static void main(String... ignored) throws Exception {
		long startTime = System.nanoTime();
		BigInteger total = BigInteger.ZERO;
		
		for(int i = 1; i <= 1000; i++) {
			total = total.add(BigInteger.valueOf(i).pow(i));
		}

		System.out.println(total);
		System.out.println(total.mod(BigInteger.TEN.pow(10)));
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}

}