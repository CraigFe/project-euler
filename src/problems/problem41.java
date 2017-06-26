import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//nth lexicographic prime 987654321
class problem41 {
	public static void main(String... ignored) throws Exception {
		long startTime = System.nanoTime();
		
		//Generate digit set
		List<Integer> digits = new ArrayList<Integer>();
		long pandigital=1;
		//For integers of length p
		for (int p = 9; p > 0; p--) {
			for (int n = 1; n < factorial(p) && !BigInteger.valueOf(pandigital).isProbablePrime(30); n++) {
				digits.clear();
				for (int i=p;i>0;i--) digits.add(i);
				pandigital = nthOrdering(n,digits);
				System.out.println(pandigital);
			}
		}
		
		
		System.out.println(pandigital);
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