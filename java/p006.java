

//https://projecteuler.net/problem=6
public final class p006 implements Solution {
	
	public String run() {
		int ans = 0;
		
		for (int i = 1; i < 100; i++) {
			for (int j = i+1; j <= 100; j++) {
				ans+=i*j;
			}
		}
		
		ans*=2;
		return ans;
	}

}