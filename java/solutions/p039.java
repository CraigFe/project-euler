package solutions;

public final class p039 implements Solution {
	
	@Override
	public String run() {
		int solutions = 0, max = 0;
		
		for (int p = 12; p <= 1000; p++) {
			solutions = 0;
			for (int a = 1; a < p/2; a++) {
				if ((p*(p-2*a))%(2*p-2*a) == 0) {
					solutions++;
					//System.out.println("solutions.Solution: a ="+a+", b = "+(p*(p-2*a))/(2*p-2*a)+", c = "+(p-a-(p*(p-2*a))%(2*p-2*a)));
				}
			}
			if (solutions > max) {
				max = solutions;
				System.out.println("p = "+p+": "+max+" solutions");
			}
		}
		
		return Integer.toString(solutions);
	}
}