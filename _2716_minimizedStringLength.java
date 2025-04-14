package LeetCode;

import java.util.HashSet;

public class _2716_minimizedStringLength {
	public static void main(String[] arg) {
		String string = "aaabc";
		System.out.println(Method(string));
	}
	public static int Method(String string) {
		HashSet<Character> hashSet = new HashSet<Character>();
		int count = 0;
		for (int i = 0; i < string.length(); i++) {
			if(!hashSet.contains(string.charAt(i))) {
				count++;
				hashSet.add(string.charAt(i));
			}
		}
		return count;
	}
}
