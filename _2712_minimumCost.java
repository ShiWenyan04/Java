package LeetCode;


public class _2712_minimumCost {
	public static void main(String[] arg) {
		String string = "010101";
		System.out.println(Method2(string));
	}
	public static Long Method(String str) {
		int n = str.length();
		long ans = 0;
		int len ;
		if(n%2 == 0) {
			len = n/2-1;
		}else {
			len = n/2;
		}
		for (int i = 0; i < len; i++) {
			if(str.charAt(i) != str.charAt(i+1)) {
				ans+=(i+1);
			}
			if(str.charAt(n-1-i) != str.charAt(n-i-1-1)) {
				ans+=(i+1);
			}
		}
		if(n%2 == 0 && str.charAt(n/2) != str.charAt(n/2-1)) {
			ans+=n/2;
		}
		return ans;
	}
	
	
	public static long Method2(String str) {
		int n = str.length();
		int ans = 0;
		for (int i = 01; i < str.length()-1; i++) {
			if(str.charAt(i) != str.charAt(i-1)) {
			ans+=Math.min(i+1,n-i);
			}
		}
		return ans;
	}
}
