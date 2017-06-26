
class problem28 {
	
	public static void main(String... ignored) {
		long startTime = System.nanoTime();

		//f(n) = 16/3*n^3 + 10*n^2 + 26/3*n + 1
		int gridSize = (1001-1)/2;
		long ans = (long)(((16*Math.pow(gridSize,3))+(26*gridSize))/3 + 10*Math.pow(gridSize, 2) + 1);
		System.out.println(ans);
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}

}