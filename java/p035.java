import java.math.BigInteger;


public final class p035 implements Solution {
	
	@Override
	public String run() {
		int counter = 0;
		
		for (int i = 2; i < 1000000; i++) {
			if (isCircularPrime(i)) counter++;
		}
		
		return Integer.toString(counter);
	}
	
	public static boolean isCircularPrime(int p) {
		String s = String.valueOf(p);
		BigInteger rotated = BigInteger.ONE;
		for (int i = 0; i < s.length(); i++) {
			rotated = new BigInteger(rotateBy(s,i));
			if (!rotated.isProbablePrime(15)) return false;
		}
		return true;
	}
	
	//'rotate' a string
	public static String rotateBy(String s, int n) {
		if (n == 0) return s;
		n%=s.length();
		for (int i = 0; i < n; i++) s = s.substring(s.length()-1)+s.substring(0,s.length()-1);
		return s;
	}
}