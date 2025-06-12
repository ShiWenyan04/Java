package ICPC_GuiZhou;
/*景区设计了 “水帘解谜” 游戏，有 n 个水帘光影序列（字符串）和 m 次解谜挑战。每次挑战给出两个序列编号 i 和 j，要找出最大的非负整数 L，让第 i 个序列的前 L 个字符，和第 j 个序列的后 L 个字符拼接起来是回文串，L 越大奖励越丰厚，我们的任务就是为每次挑战算出这个最大的 L 。

 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class K {
	static int pp = 131;
	static long mod = (long) 1e18 + 1;
	static int n, m;
	static String[] a;
	static int x, y;
	static List<Long>[] pre;
	static List<Long>[] suff;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] arg) {
		n = sc.nextInt();
		m = sc.nextInt();
		a = new String[n]; // 初始化字符串数组
		for (int i = 0; i < n; i++) {
			a[i] = sc.next();
		}

		init();

		for (int i = 0; i < m; i++) {
//			字符串存入数组后，都是从0开始的
			x = sc.nextInt() - 1;
			y = sc.nextInt() - 1;
			int len1 = a[x].length();
			int len2 = a[y].length();
			int len = Math.min(len1, len2);

//			如果第一个字符就不同
			if (a[x].charAt(0) != a[y].charAt(len2 - 1)) {
				System.out.println(0);
				continue;
			}

//			二分寻找长度,长度最小为1，因为如果是0的话说明一个也不同
			int ans = 1;
			int left = 1, right = len;
			while (left <= right) {
				int mid = (left + right) / 2;
				if (check(mid)) {
					ans = mid;
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			System.out.println(ans);
		}
	}

//	初始化list，主要存入每个字符串的前i个字符的计算值
	public static void init() {
		pre = new ArrayList[n];
		suff = new ArrayList[n];
//		遍历每个字符串
		for(int i = 0 ; i < n;i++) {
			int len = a[i].length();
			pre[i] = new ArrayList<>(len+1);
			suff[i] = new ArrayList<>(len+1);
			
//			前缀
			pre[i].add(0L);
			for(int j=0;j < len;j++) {
				pre[i].add((pre[i].get(j)*pp+a[i].charAt(j))%mod);
			}
			
//			后缀
			suff[i].add(0L);
			for(int j = 0;j < len;j++) {
				suff[i].add((suff[i].get(j)*pp+a[i].charAt(len-j-1))%mod);
			}
		}
	}
//	如果mid长度下，前缀的值等于后缀的值
	public static boolean check(int mid) {
		return pre[x].get(mid).equals(suff[y].get(mid));
	}
}
