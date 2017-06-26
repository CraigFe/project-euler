class problem31 {
	
	public static void main(String... ignored) {
		long startTime = System.nanoTime();

		int target = 200;
		int[] coinSizes = {1,2,5,10,20,50,100,200};
		int[] ways = new int[target+1]; //0p - (target)p
		ways[0] = 1; //1 way to give change for 0p
	
		//For all coins in the set
		for (int i = 0; i < coinSizes.length; i++) {
			//For all values greater than or equal to current coinsize
			for (int j = coinSizes[i]; j <= target; j++) {
				ways[j] += ways[j-coinSizes[i]];
			}
		}
		
		System.out.println("There are "+ways[ways.length-1]+" ways to give change for "+target+"p.");
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
}