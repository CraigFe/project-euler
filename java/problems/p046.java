import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class problem46 {
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
		
		int primedif;
		composite:
		for (int i = 3; i < 15485863; i+=2) {
			if (BigInteger.valueOf(i).isProbablePrime(15)) continue;

			for (int j = 0; i > primes.get(j); j++) {
				primedif = i-primes.get(j);
				if ((primedif & 1) != 0) continue;
				if (Math.sqrt(primedif >> 1)%1 == 0) {
					System.out.println(i+" = "+primes.get(j)+" + 2*"+(int)Math.sqrt(primedif >> 1)+"^2");
					continue composite;
				}
			}
			System.out.println(i);
			break;
			
		}
		
		
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}

}