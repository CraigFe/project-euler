import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class problem49 {
	public static void main(String... ignored) throws Exception {
		long startTime = System.nanoTime();
		long lastPrint = System.currentTimeMillis();

		List<Integer> primes = new ArrayList<Integer>();
		List<Integer> rotations = new ArrayList<Integer>();
		List<Integer> digits = new ArrayList<Integer>();
		List<Integer> digits_temp = new ArrayList<Integer>();
		
		//Load all four digit primes into a list
		try (Stream<String> stream = Files.lines(Paths.get("C:\\Users\\Craig\\OneDrive - University Of Cambridge\\Code\\Java\\ProjectEuler\\src\\millionPrimes.txt"))) {
	        stream.forEach(line -> {if(line.length()==4) primes.add(Integer.valueOf(line));});
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Primes loaded in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
		
		int i = 0;
		int rotate, ordered;
		String s;
		
		for (int j = 0; j < primes.size(); j++) {
			rotations.clear();
			digits.clear();
			
			for (int k = 0; k < 4; k++) {
				digits.add(Integer.valueOf(primes.get(j).toString().substring(k,k+1)));
			}
			
			
			//If the number contains a 0, no 3 4-digit prime iterations are possible
			if (digits.contains(0)) continue;
			
			//If sum of digits is divisible by 3, no iterations are prime
			if(digits.stream().mapToInt(Integer::intValue).sum() % 3 == 0) continue;
			
			for (int perm = 1; perm <= 24; perm++) {
				ordered = (int) nthOrdering(perm,digits);
				if (primes.contains(ordered) && !rotations.contains(ordered)) {
					rotations.add(ordered);
				}
			}
	
			Collections.sort(rotations);
			
			for (int m = 0; m < rotations.size()-2; m++) {
				for (int n = 1; m+n < rotations.size(); n++) {
					if (rotations.contains(2*rotations.get(m+n) - rotations.get(m))) {
						System.out.println("["+rotations.get(m)+", "+rotations.get(m+n)+", "+(2*rotations.get(m+n) - rotations.get(m))+"]");
					}	
				}
			}
		}

		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
	
	public static long factorial(long n) {
		if (n <= 1) return 1;
		return n*factorial(n-1);
	}
	
	public static long nthOrdering(int n, List<Integer> digits_main) throws Exception {
		//Load digits into a new list
		List<Integer> digits = new ArrayList<Integer>();
		for (int val : digits_main) digits.add(val);
		
		int places = digits.size();
		if (n > factorial(places)) throw new Exception("N is too large: n="+n+", digits = "+digits.toString());
		
		List<Integer> output = new ArrayList<Integer>();
		int remain = n - 1;
		int pos = 0; //0th place of places
		int x = 0; //Current digit
		
		while (!digits.isEmpty()) {
			/*System.out.println();
			System.out.println("digits: "+digits.toString());
			System.out.println("output: "+output.toString());
			System.out.println("  perm: "+remain);
			System.out.println("   pos: "+pos);*/
			
			x = (int) (remain / factorial(places-1-pos));
			remain -= factorial(places-1-pos)*x;
			output.add(digits.get(x));
			digits.remove(x);
			pos++;
		}
		
		long out = 0;
		while (!output.isEmpty()) {
			out *= 10;
			out += output.get(0);
			output.remove(0);
		}
		return out;
	}

} 