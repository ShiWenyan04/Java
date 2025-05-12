package LanQiao;

import java.util.Scanner;
/*我们称一个字符串 S 包含字符串 T是指 T 的一个子序列，即可以从字符串 S 中抽出若干个字符，它们按原来的顺序组合成一个新的字符串与 t
完全一样。
给定两个字符串请问 T 中从第一个字符开始最长连续多少个字符 被 s 包含？
输入描述*/
public class _244_LongestSubsequence {
	public static void main(String[] arg) {
		Scanner scanner = new Scanner(System.in);
		char[] s = scanner.next().toCharArray();
		char[] t = scanner.next().toCharArray();
		int n = s.length,m = t.length;
		int count =  0 ;
//		双指针，一前一后，如果长字符串与短字符串不匹配，那么长字符串的指针向前进一，短字符串不动
//		反之，如果相等，那么count+1，长字符串和短字符串都进一
		int i = 0;//下指针t
		for (int j = 0; j < n && i < m; j++) {//上指针s
			if(s[j] == t[i]) {
				count ++;
				i++;
			}
		}
		System.out.println(count);
	}
}
