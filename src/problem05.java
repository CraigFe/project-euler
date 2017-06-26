import static java.lang.System.out;

//https://projecteuler.net/problem=5
class problem05 {
	
	public static void main(String[] args) {
		int n = 1;
		for (int i = 2; i <= 20; i++) {
			n = lcm(n,i);
		}
		out.println(n);
	}
	
	
	public static int gcd(int a, int b) {
		if (b==0) return a;
		return gcd(b,a%b);
	}
	
	public static int lcm(int a, int b) {
		return a/gcd(a,b) * b;
	}
}