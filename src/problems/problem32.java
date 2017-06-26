import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class problem32 {
	
	public static void main(String... ignored) {
		long startTime = System.nanoTime();

		HashSet<Integer> results = new HashSet<Integer>();
		List<Integer> mdigits = new ArrayList<Integer>();
		List<Integer> ndigits = new ArrayList<Integer>();
		List<Integer> pdigits = new ArrayList<Integer>();

		
		int nStart = 0, nEnd = 0, nCopy = 0, nDigit = 0; 
		int p = 0, pCopy = 0, pDigit = 0;
		
		for (int m = 1; m <= 98; m++) {
			
			if (m%10 == 0) continue; //Exclude 10,20,30..
			
			mdigits.clear();   //Clear previous digits
			mdigits.add(m%10); //Add units digit to used digits
			
			if (m/10==0) {
				nStart = 1234; 
				nEnd = 9876;
			} else {
				if (mdigits.contains((m/10)%10)) continue; //Exclude 11,22,33..
				mdigits.add((m/10)%10); //Add tens digit to used digits
				nStart = 123;
				nEnd = 987;
			}
			
			nloop:
			for (int n = nStart; n <= nEnd; n++) {

				//wipe previous digits
				ndigits.clear();
				nCopy = n;
				
				//For all digits of n to nDigits, check against nDigits and mDigits for duplicates
				for (int b = 0; b <= Math.floor(Math.log10(n)); b++) {
					nDigit = nCopy%10;
					if (mdigits.contains(nDigit) || ndigits.contains(nDigit) || nDigit == 0) continue nloop;
					ndigits.add(nDigit);
					nCopy/=10;
				}
				
				p = m*n;
				pCopy = p;
				pdigits.clear();
				
				//If p != 4 digits, continue
				if (Math.floor(Math.log10(p))!=3) continue nloop;
				
				//For all digits of p, check against nDigits, mDigits and pDigits for duplicates
				for (int b = 0; b < 4; b++) {
					pDigit = pCopy%10;
					if (mdigits.contains(pDigit) || ndigits.contains(pDigit) || pdigits.contains(pDigit) || pDigit == 0) continue nloop;
					pdigits.add(pDigit);
					pCopy/=10;
				}
				
				System.out.println(m+" x "+n+" = "+p);
				results.add(p);
				
			}
		}
		int sum = 0;
		for (int n : results) sum+=n;
		
		System.out.println(sum);
		System.out.println("Process completed in "+(System.nanoTime()-startTime)/1000/1000.00+"ms.");
	}
}