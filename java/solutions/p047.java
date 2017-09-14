package solutions;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class p047 implements Solution {
	
	@Override
	public String run() {
		
		List<Integer> primes = new ArrayList<Integer>();
		
		//Load the first million primes into a list
		try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\Craig\\OneDrive - University Of Cambridge\\Code\\Java\\ProjectEuler\\src\\millionPrimes.txt"))) {
	        stream.forEach(line -> primes.add(Integer.valueOf(line)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int test = 0, 
		    consec = 0, 
		    consecTarget = 4, 
		    prime, 
		    primefactors;
		
		for (test = 1; consec != consecTarget; test++) {
			primefactors = 0;
			for (int j = 0; primes.get(j) <= test/2 && primefactors <= consecTarget; j++) {
				if (test%primes.get(j) == 0) {
					primefactors++;
				}
			}
			if (primefactors == consecTarget) consec++;
			else consec = 0;
		}
		
		return Integer.toString(test-consecTarget);
	}

}