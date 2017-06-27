import java.math.BigInteger;

//https://projecteuler.net/problem=10
public final class p010 implements Solution {
	
	@Override
	public String run() {
		BigInteger prime = BigInteger.ZERO;
		BigInteger sum   = BigInteger.ZERO;
		
		do {
			sum = sum.add(prime);
			prime = prime.nextProbablePrime();
		} while (prime.compareTo(BigInteger.valueOf(2000000L))<0);
		
		return sum.toString();
	}
}