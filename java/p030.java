class problem30 {
	
	public static void main(String... ignored) {
		long startTime = System.nanoTime();
		int sum = 0;
		for (int i = 2; i < 355000; i++) {
			if (i == sumOfPowers(i)) {
				sum += i;
			}
		}
		
		System.out.println(sum);
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
	
	public static int sumOfPowers(int n) {
		int output = 0;
		while (n != 0) {
			output += Math.pow(n%10,5);
			n/=10;
		}
		return output;
	}

}