import java.util.ArrayList;
import java.util.List;
class problem38 {
	
	public static void main(String... ignored) {
		long startTime = System.nanoTime();
		List<Integer> digits = new ArrayList<Integer>();
		String s;
		int digit;
		
		search:
		for (int i = 9123; i <= 9876; i++) {
			digits.clear();
			s = i+""+2*i;
			while (!s.isEmpty()) {
				digit = Integer.valueOf(s.substring(0,1));
				if (digits.contains(digit) || digit == 0) continue search;
				digits.add(digit);
				s=s.substring(1);
			}
			System.out.println(i+": "+i+""+2*i);
		}
		
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
}