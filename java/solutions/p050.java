package solutions;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class problem50 {
	public static void main(String... ignored) throws Exception {
		long startTime = System.nanoTime();
		long lastPrint = System.currentTimeMillis();
		
		final int limit = 1000000;
		int seqLength = 0, result = 0; 
		
		List<Integer> primes = new ArrayList<Integer>();
		List<Integer> cumulative = new ArrayList<Integer>();
		
		
		//Load all primes below 1,000,000 into a list
		try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\Craig\\OneDrive - University Of Cambridge\\Code\\Java\\ProjectEuler\\src\\millionPrimes.txt"))) {
	        stream.forEach(line -> {
	        	if(line.length()<7) {
	        		primes.add(Integer.valueOf(line));
	        		if (cumulative.isEmpty()) {
	        			cumulative.add(Integer.valueOf(line));
	        		} else {
	        			cumulative.add(Integer.valueOf(line)+cumulative.get(cumulative.size()-1));
	        		}
	        		
	        	}
	        });
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Primes loaded in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");

		for (int i = 0; i < primes.size(); i++) {
			for (int j = i-(seqLength+1); j >= 0; j--) {
				
				if (cumulative.get(i) - cumulative.get(j) > limit) break;
				
				if (BigInteger.valueOf((cumulative.get(i) - cumulative.get(j))).isProbablePrime(15)) {
					seqLength = i-j;
					result = cumulative.get(i)-cumulative.get(j);
				}
				
			}
			
			//Print current state
			if (System.currentTimeMillis() - lastPrint > 1000) {
				System.out.println("Currently testing.testing " + primes.get(i) + " - seqLength = "+seqLength);
			}
		}
		
		
		
		
		System.out.println(result + " can be expressed as the sum of "+seqLength+" consecutive primes.");
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
}