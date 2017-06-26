//https://projecteuler.net/problem=19
class problem19 {
	
	public static void main(String... ignored) {
		long start = System.nanoTime();

		int sundays = 0;
		int d = 1; //First day of each month
		
		for (int y = 1901; y <= 2000; y++) {
			for (int m = 1; m <= 12; m++) {
				int day = zeller(d,m,y);
				
				if (day == 7) {
					System.out.println(d+":"+m+":"+y+" = "+day);
					sundays++;
				}
			}
		}
	
		System.out.println(sundays);
		System.out.println("Finished in " + (System.nanoTime()-start)/1000/1000.00 + "ms.");
	}

	//Zeller's congruence
	private static int zeller(int d, int m, int y) {
		if (m < 3) {
			m += 12;
			y -= 1;
		}
		//0 = Saturday, 1 = Sunday ... 6 = Friday
		int h = (d + (13*(m+1))/5 + y + y/4 - y/100 + y/400) % 7;
		
		//1 = Monday, 2 = Tuesday ... 7 = Sunday
		return ((h+5)%7)+1;
	}
	
}