import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class problem26 {
	public static void main(String... ignored) {
		long startTime = System.nanoTime();
		int numerator = 0, remainder = 0, digits = 0;
		List<Integer> foundRemainders = new ArrayList<Integer>(); 
		
		int bestPrime = 0;
		int bestPeriod = 0;
		
		//1/i for all primes 3-1000
		for (BigInteger i = new BigInteger("2"); i.compareTo(BigInteger.valueOf(1000)) < 0; i = i.nextProbablePrime()) {
			foundRemainders.clear();
			numerator = 1;
			digits = 0;
			
			for (int j = 0; j < i.intValue(); j++) {
				remainder = 10*numerator % i.intValue();
				if (!foundRemainders.contains(remainder)) {
					if (remainder == 0) {
						digits = 0;
						break;
					}
					foundRemainders.add(remainder);
					numerator = remainder;
				} else {
					digits = foundRemainders.size() - foundRemainders.lastIndexOf(remainder);
					break;
				}
			}
			
			if (digits > bestPeriod) { 
				bestPrime = i.intValue();
				bestPeriod = digits;
			}
			
			System.out.println("1/"+i.toString()+": "+digits);
		}
		
		System.out.println("Best value:");
		System.out.println("1/"+bestPrime+": "+bestPeriod);
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
	
	
	

}