import static java.lang.System.out;
import java.math.BigInteger;

//https://projecteuler.net/problem=7
class problem07 {
	
	public static void main(String[] args) {
		BigInteger prime = BigInteger.ONE;
		
		for (int i = 1; i <= 10001; i++) {
			prime = prime.nextProbablePrime();
			out.println("prime "+i+": "+prime.toString());
		}
		
	}
}