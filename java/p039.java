import java.util.ArrayList;
import java.util.List;

class problem39 {
	
	public static void main(String... ignored) {
		long startTime = System.nanoTime();

		int solutions = 0, max = 0;
		
		for (int p = 12; p <= 1000; p++) {
			solutions = 0;
			for (int a = 1; a < p/2; a++) {
				if ((p*(p-2*a))%(2*p-2*a) == 0) {
					solutions++;
					//System.out.println("Solution: a ="+a+", b = "+(p*(p-2*a))/(2*p-2*a)+", c = "+(p-a-(p*(p-2*a))%(2*p-2*a)));
				}
			}
			if (solutions > max) {
				max = solutions;
				System.out.println("p = "+p+": "+max+" solutions");
			}
		}
			

		
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
}