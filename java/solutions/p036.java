package solutions;

public final class p036 implements Solution {
	
	@Override
	public String run() {
		long total = 0;
		
		for (int i = 1; i < 1000000; i++) {
			if (isPalindrome(Integer.toString(i,10)) && isPalindrome(Integer.toString(i,2))) {
				total += i;
				System.out.println(Integer.toString(i,10)+" = "+Integer.toString(i,2));
			}
		}
		return Long.toString(total);
		
	}
	
	public static boolean isPalindrome(String s) {
		for (int i = 0; i < (s.length()+1)/2; i++) {
			if (s.charAt(i)!=s.charAt(s.length()-i-1)) {
				return false;
			}
		}
		return true;
	}
}