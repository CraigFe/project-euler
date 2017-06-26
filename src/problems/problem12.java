import static java.lang.System.out;
import java.lang.Math;

//https://projecteuler.net/problem=12
class problem12 {
	
	public static void main(String[] args) {
		int divs = 0;
		long tri = 0; //current triangular number
		int max = 0; //maximum divs
		
		for (int n = 1; divs < 500; n++) {
			tri = triangle(n);
			divs = noDivisors(tri);
			if (divs > max) {
				max = divs;
				out.println("Divs: "+divs+" Triangle: "+tri);
			}
		}
		
		out.println("Final values:");
		out.println("Divs: "+divs+" Triangle: "+tri);
	}
	
	public static long triangle(long n) {
		if (n==1L) return 1;
		return n + triangle(n-1);
	}
	
	public static int noDivisors(long n) {
		int divs = 0; //Account for n%n=0
		for (double i = 1; i <= Math.sqrt(n); i++) {
			if (n%i==0) divs+=2;
			if (Math.sqrt(n)%1==0) divs--; //Account for square numbers
		}
		return divs;
	}
}