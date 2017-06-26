//https://projecteuler.net/problem=17
class problem17 {
	
	public static void main(String... ignored) {
		long start = System.nanoTime();

		int chars = 11; //One thousand
		
		for (int i = 1; i < 1000; i++) {
			System.out.println(i+": "+getChars(i)+" characters long");
			chars += getChars(i);
		}
			
		System.out.println(chars);
		System.out.println("Finished in " + (System.nanoTime()-start)/1000/1000.00 + "ms.");
	}
	
	public static int getChars(int i) {
		int chars = 0;
		int hundreds = i/100;
		int tens = (i-hundreds*100)/10;
		int units = i-hundreds*100-tens*10;
		//System.out.println("h:"+hundreds+" t:"+tens+" u:"+units);
		
		//HUNDREDS
		if (hundreds != 0) {
			 chars += (units+tens != 0) ? 10 : 7; //"hundred and"
			 chars += unitMap(hundreds);
		}
		
		//TENS
		if (tens != 0) {
			if (tens == 1) chars += unitMap(10 + units);
			else {
				chars += tenMap(tens);
			}
		}
		
		//UNITS
		if (units != 0 && tens != 1) {
			chars += unitMap(units);
		}
		
		return chars;
		
	}
	public static int unitMap(int n) {
		switch (n) {
		case 1: return 3;
		case 2: return 3;
		case 3: return 5;
		case 4: return 4;
		case 5: return 4;
		case 6: return 3;
		case 7: return 5;
		case 8: return 5;
		case 9: return 4;
		case 10: return "ten".length();
		case 11: return "eleven".length();
		case 12: return "twelve".length();
		case 13: return "thirteen".length();
		case 14: return "fourteen".length();
		case 15: return "fifteen".length();
		case 16: return "sixteen".length();
		case 17: return "seventeen".length();
		case 18: return "eighteen".length();
		case 19: return "nineteen".length();
		default: return Integer.MIN_VALUE;
		}
	}

	public static int tenMap(int n) {
		switch (n) {
		case 2: return 6;
		case 3: return 6;
		case 4: return 5;
		case 5: return 5;
		case 6: return 5;
		case 7: return 7;
		case 8: return 6;
		case 9: return 6;
		default: return Integer.MIN_VALUE;
		}
		
	}
}