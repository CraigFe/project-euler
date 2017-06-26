import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

class problem40 {
	
	//Lazy brute force
	public static void main(String... ignored) {
		long startTime = System.nanoTime();
		
		String fraction = "";
		for(int i = 1; fraction.length() < 1000000; i++) fraction+=String.valueOf(i);
		
		int product = 1;
		for(int k=0;k<=6;k++) {
			product *= Integer.valueOf(fraction.substring((int) Math.pow(10, k)-1,(int) Math.pow(10, k)));
		}

		System.out.println(product);
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
}