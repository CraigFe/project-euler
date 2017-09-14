package solutions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//nth lexicographic prime 987654321
class problem44 {
	public static void main(String... ignored) throws Exception {
		long startTime = System.nanoTime();
		long lastPrint = System.currentTimeMillis();
		
		//Generate the first 10,000 pentagonal numbers
		List<Long> pent = new ArrayList<Long>();
		for (int i = 1; i <= 100000; i++) pent.add(pentagon(i));
		System.out.println("Cache generated");
		System.out.println("pj+pk: "+pent.contains(pentagon(2167)+pentagon(1020)));
		System.out.println("pj+pk: "+pent.contains(pentagon(2167)-pentagon(1020)));
		int k;
		long d;
		int dmin = 0;
		boolean plus,diff;
		
		for (int sum = 1; sum < 100000; sum++) {
			k=0; //Start on top row
			for (int j = sum; j>k; j--) {
				k = sum-j;
				if(j==2167) {
					if(k==1010) {
						boolean found = true;
						if(found);
					}
				}
				//Sum and difference must be pentagonal
				plus = pent.contains(pent.get(j) + pent.get(k));
				diff = pent.contains(pent.get(j) - pent.get(k));
				
				if (plus && diff) {
					d = pent.get(j)-pent.get(k);
					if (d < dmin) {
						System.out.println("New minimum: "+d+" (j="+j+", k="+k+")");
					}
				}
				if (System.currentTimeMillis() - lastPrint > 1000) {
					lastPrint = System.currentTimeMillis();
					System.out.println("Working... (sum="+sum+", j="+j+", k="+k+", pj="+pent.get(j)+", pk="+pent.get(k)+")");
				}
			}
		}
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
	
	public static long pentagon(long n) {
		return (n*(3*n-1))>>1;
	}

}