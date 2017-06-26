//https://projecteuler.net/problem=19
class problem21 {
	public static void main(String... ignored) {
		long startTime = System.nanoTime();
		
		long sum = 0, a = 0, b = 0;
		
		for (int i = 1; i < 10000; i++) {
			a = d(i);
			b = d(a);
			if (i==b && a!=b) {
				System.out.println("Found pair: "+a+" : "+b);
				sum+=a+b;
			}
		}
		System.out.println(sum/2);
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
	
	//The sum of proper divisors of long n
	public static long d(long n) {
		
		int sum = 0;
		for (double i = 1; i <= Math.sqrt(n); i++) {
			if (n%i==0) {
				sum += i;
				sum += n/i;
			}
			if (Math.sqrt(n)%1==0) sum -= i; //Account for square numbers
		}
		return sum-n; //Account for n%n=0 (proper divisors)
	}
}