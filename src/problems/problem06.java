import static java.lang.System.out;

//https://projecteuler.net/problem=6
class problem06 {
	
	public static void main(String[] args) {

		int ans = 0;
		
		for (int i = 1; i < 100; i++) {
			for (int j = i+1; j <= 100; j++) {
				ans+=i*j;
			}
		}
		ans*=2;
		out.println(ans);
	
	}
}