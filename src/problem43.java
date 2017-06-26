import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//nth lexicographic prime 987654321
class problem43 {
	public static void main(String... ignored) throws Exception {
		long startTime = System.nanoTime();
		
		//Generate digit set
		List<Integer> digits = new ArrayList<Integer>();
		long pandigital=1;
		int subPandigital;
		int[] primes = {2,3,5,7,11,13,17};
		long sum = 0;
		
		//For integers of length p
		search:
		for (int n = 1; n <= 9*factorial(9); n++) {
			digits.clear();
			for (int i=9;i>=0;i--) digits.add(i);
			pandigital = nthOrdering(n,digits);

			for (int i = 0; i < 7; i++) {
				subPandigital = Integer.valueOf(String.valueOf(pandigital).substring(i+1,i+4));
				if (subPandigital % primes[i] != 0) continue search;
			}
			System.out.println(pandigital);
			sum+=pandigital;
		}

		
		System.out.println("\n"+sum);
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
	
	public static long factorial(long n) {
		if (n <= 1) return 1;
		return n*factorial(n-1);
	}
	
	public static long nthOrdering(int n, List<Integer> digits) throws Exception {
		int places = digits.size();
		if (n > factorial(places)) throw new Exception("N is too large");
		
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