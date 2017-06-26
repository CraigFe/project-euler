import static java.lang.System.out;
import java.math.BigInteger;

//https://projecteuler.net/problem=10
class problem10 {
	
	public static void main(String[] args) {
		BigInteger prime = BigInteger.ZERO;
		BigInteger sum   = BigInteger.ZERO;
		
		do {
			sum = sum.add(prime);
			out.println("Sum: "+sum.toString());
			prime = prime.nextProbablePrime();
		} while (prime.compareTo(BigInteger.valueOf(2000000L))<0);
		
		out.println("Sum: "+sum.toString());
	}
}