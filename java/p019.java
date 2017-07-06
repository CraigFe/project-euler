/**
 * How many Sundays fell on the first of the month during the twentieth century?
 * https://projecteuler.net/problem=19
 * 
 * @author cf443
 */
public final class p019 implements Solution {
	
	/*
	 * The solution uses Zeller's congruence, a simple function which computes the day of the week
	 * given the day, month and year. We simply iterate through the first days of all of the
	 * months in the given range and count the ones which are Sundays.
	 * 
	 * Zeller's congruence is simple to implement, but complex to derive.
	 * See: https://en.wikipedia.org/wiki/Zeller%27s_congruence
	 */
	@Override
	public String run() {

		int sundays = 0; //Accumulator
		for (int y = 1901; y <= 2000; y++) {
			for (int m = 1; m <= 12; m++) {

				if (zeller(1,m,y) == 7) sundays++; //If first day of the month is a sunday...
			}
		}
	
		return Integer.toString(sundays);
	}

	/*
	 * The Zeller's congruence. Takes a day, month and year and returns the corresponding
	 * day of the week (1 = Monday, 2 = Tuesday ... 7 = Sunday)
	 */
	private static int zeller(int d, int m, int y) {
		if (m < 3) {
			m += 12;
			y -= 1;
		}
		//0 = Saturday, 1 = Sunday ... 6 = Friday
		int h = (d + (13*(m+1))/5 + y + y/4 - y/100 + y/400) % 7;
		return ((h+5)%7)+1; //Shift values such that 1 = Monday, 2 = Tuesday etc.
	}
	
}