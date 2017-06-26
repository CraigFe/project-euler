import static java.lang.System.out;

//https://projecteuler.net/problem=4
class problem04 {
	
	public static void main(String[] args) {
		int largest = 0;
		

		for (int i = 100; i < 1000; i++) {
			for (int j = i; j < 1000; j++) {
				if (isPalindrome(i*j)) {
					largest = (i*j > largest) ? i*j : largest;
					out.println("New largest: "+largest);
				}
			}
		}
		out.println(largest);
	}
	
	public static boolean isPalindrome(int input) {
		String n = String.valueOf(input);
		
		for (int i = 0; i <= n.length()/2; i++) {
			if (n.charAt(i) != n.charAt(n.length() - 1 - i)) return false;
		}
		return true;
	}
}