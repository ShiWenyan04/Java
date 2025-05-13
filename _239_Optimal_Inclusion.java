package LanQiao;

import java.util.Arrays;
import java.util.Scanner;
/*我们称一个字符串 S 包含字符串 T 是指 T 是 S 的一个子序列，即可以从字符串 S 中抽出若干个字符，它们按原来的顺序组合成一个新的字符串与 T 完全一样。

给定两个字符串 S 和 T，请问最少修改 S 中的多少个字符，能使 S 包含 T。
*/
public class _239_Optimal_Inclusion {
	public static void main(String[] arg) {
		Scanner scanner = new Scanner(System.in);
		char[] s =( " "+scanner.next()).toCharArray();
		char[] t =( " "+scanner.next()).toCharArray();
		
		int n = s.length,m = t.length;
		int f[][] = new int [n][m];
		
		for(int i = 0;i <n;i++) {
			Arrays.fill(f[i], (int)1e9);//初始化最大值
			
		}
		f[0][0] = 0;
		for(int i = 1; i < n;i++) {
			f[i][0] = 0;//当t串未选中字符时，肯定为0
			for(int j = 1 ; j <m;j++) {
				if(s[i] ==t[j]) {//相等
					f[i][j] = f[i-1][j-1];	
//					从上一个状态转移，f[i-1][j-1]表示s（0~i-1）的字符串和t（0~j-1）的字符串中需要修改的次数，
//					由于s[i]==t[j]所以不用修改直接转移			
				}else {
					f[i][j] = Math.min(f[i-1][j-1]+1, f[i-1][j]);
//					s[0~i-1]和t[0~j-1]需要修改的次数，由于s[i]!=t[j],所以要修改一次 故+1；
//					或者是s[0~i-1]和t[0~j]的修改次数，二者挑小
				}
			}
		}
	System.out.println(f[n-1][m-1]);
	}
}
