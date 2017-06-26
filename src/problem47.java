import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class problem47 {
	public static void main(String... ignored) throws Exception {
		long startTime = System.nanoTime();
		long lastPrint = System.currentTimeMillis();

		List<Integer> primes = new ArrayList<Integer>();
		
		//Load the first million primes into a list
		try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\Craig\\OneDrive - University Of Cambridge\\Code\\Java\\ProjectEuler\\src\\millionPrimes.txt"))) {
	        stream.forEach(line -> primes.add(Integer.valueOf(line)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Primes loaded in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
		
		int test = 0;
		int prime, primefactors;
		int consec = 0;
		int consecTarget = 4;
		
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
		System.out.println(test-consecTarget);
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}

}