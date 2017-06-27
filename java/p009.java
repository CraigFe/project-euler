import static java.lang.System.out;
import java.lang.Math;

//https://projecteuler.net/problem=9
class problem09 {

	public static void main(String[] args) {
		int a=0, b=1;

		for (; b < 500; b++) {
			if ((500000-1000*b)%(1000-b) == 0) {
				a = (500000-1000*b)/(1000-b);
				break;
			}
		}
		int c = (int) Math.sqrt((long) (a*a + b*b));
		
		out.println("a: "+a);
		out.println("b: "+b);
		out.println("c: "+c);
		out.println("abc: " + a*b*c);
	}
	
}
