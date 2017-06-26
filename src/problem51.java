import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

class problem51 {
	public static void main(String... ignored) throws Exception {
		long startTime = System.nanoTime();
		long lastPrint = System.currentTimeMillis();
		
		final int limit = Integer.MAX_VALUE;
		final int target = 8;
		
		int familyMax = 0; //The number of primes in the family currently being searched
		int maskMax = 0;   //The number of possible digit selection choices given the prime
		HashSet<Integer> family = new HashSet<Integer>(); //Stores the generated family numbers
		
		//Cycle through all primes below the limit
		search:
		for (int prime = 11; prime < limit; prime = BigInteger.valueOf(prime).nextProbablePrime().intValue()) {
			
			//Iterate through all possible families
			maskMax = (int) Math.pow(2,(String.valueOf(prime).length()-1))-1;
			
			for (int mask = 1; mask <= maskMax; mask++) {
				family.clear();
				
				//Generate the family of prime numbers
				for (int digit = 0; digit < 10; digit++) {
					if (BigInteger.valueOf(replace(prime,digit,mask)).isProbablePrime(15) && String.valueOf(replace(prime,digit,mask)).length() == String.valueOf(prime).length()) {
						family.add(replace(prime,digit,mask));
					}	
				}
				
				if (family.size() >= target) {
					System.out.println("Found a set of at least "+target+" primes:\n"+family.toString());
					break search;
				}
					
				
			}
			
			//Print progress report
			if (System.currentTimeMillis() - lastPrint > 1000) {
				System.out.println("Currently working on "+prime);
				lastPrint = System.currentTimeMillis();
			}
			
		}

		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
	
	//Replace the digits of input with digit, using the mask
	public static int replace(int input, int digit, int mask) throws Exception {
		if(Integer.toBinaryString(mask).length() >= Integer.toString(input).length()) {
			throw new Exception("The mask value ("+Integer.toBinaryString(mask)+") is too large for the chosen integer: "+input);
		}
		
		int output = input;
		
		//Start at second least significant bit, move left
		for (int pos = 1; pos < Integer.toString(output).length(); pos++) {
			input /= 10;
			if ((mask & 1) == 1) {
				
				output += (digit - (input % 10))*Math.pow(10, pos);
				
			}
			mask >>= 1; //Discard LSB of mask and input
		}
		
		return output;
	}
}