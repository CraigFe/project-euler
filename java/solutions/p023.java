package solutions;

import java.util.ArrayList;
import java.util.List;

//Millionth lexicographic permutation of 0,1,2,3...9
public final class p023 implements Solution {
	
	@Override
	public String run() {
		List<Integer> digits = new ArrayList<Integer>();
		List<Integer> output = new ArrayList<Integer>();
		
		for (int i=0;i<10;i++) digits.add(i);
		
		int remain = 1000000 - 1,
		    pos = 0, //0th place of 9 places
		    x = 0; //Current digit
		
		while (!digits.isEmpty()) {
			x = (int) (remain / factorial(9-pos));
			remain -= factorial(9-pos)*x;
			output.add(digits.get(x));
			digits.remove(x);
			pos++;
		}
		
		String n = "";
		for (int i = 0; i < 10; i++) n += output.get(i);
		if (n.startsWith("0")) n = n.substring(1);
		
		return n;
	}
	
	//Recursive factorial implementation
	public static long factorial(long n) {
		if (n <= 1) return 1;
		return n*factorial(n-1);
	}

}