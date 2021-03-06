package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class p033 implements Solution {
	
	@Override
	public String run() {
		long startTime = System.nanoTime();

		double f1 = 1;
		double f2 = 1;
		List<Double> numers = new ArrayList<Double>(); 
		List<Double> denoms = new ArrayList<Double>();
		
		//frac f = ab/cd
		for (double a=1;a<10;a++) {
			for (double b=1;b<10;b++) {
				for (double c=a;c<10;c++) {
					for (double d=((c==a) ? b+1:1) ;d<10;d++) {
						
						f1 = (a*10+b)/(c*10+d);
						f2 = 1;
						
						if (a == c) f2 = b/d;
						if (a == d) f2 = b/c;
						if (b == c) f2 = a/d;
						if (b == d) f2 = a/c;
						
						if (f1 == f2) {
							numers.add(a*10+b);
							denoms.add(c*10+d);
						}
					}
				}
			}
		}
		
		int numerator = 1,denominator = 1;
		for (double n : numers) numerator *= (int) n;
		for (double n : denoms) denominator *= (int) n;
		
		
		int factor = GCD(numerator,denominator);
		numerator /= factor;
		denominator /= factor;
		
		System.out.println(numerator+"/"+denominator);
	}
	
	public static int GCD(int a, int b) { return b==0 ? a : GCD(b, a%b); }
}