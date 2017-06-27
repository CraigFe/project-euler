import java.util.ArrayList;
import java.util.List;

class problem29 {
	
	public static void main(String... ignored) {
		long startTime = System.nanoTime();

		List<Double> results = new ArrayList<Double>();
		for (int a=2; a<=100; a++) {
			for (int b=2; b<=100; b++) {
				
				
				double result = Math.pow(a, b);
				if (!results.contains(result)) results.add(result);
				
			}
		}
		
		System.out.println(results.size());
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
	

}