import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class problem34 {
	
	public static void main(String... ignored) {
		long startTime = System.nanoTime();

		//Preload factorials into an array
		long[] facts = new long[10];
		for (int i = 0; i < 9; i++) {
			facts[i] = factorial(i);
		}

		int m,sum;
		int total = 0;
		
		//7*9! = 2540160
		for (int n = 10; n <= 2540160; n++) {
			m=n;
			sum=0;
			while (m!=0) {
				sum+=facts[m%10];
				m/=10;
			}
			if (n == sum) {
				System.out.println(n);
				total+=n;
			}
		}
		System.out.println("Total: "+total);
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
	
	public static long factorial(long n) {
		if (n <= 1) return 1;
		return n*factorial(n-1);
	}
}