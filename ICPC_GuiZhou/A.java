package ICPC_GuiZhou;

import java.util.HashMap;
import java.util.Scanner;
/*
今天，小杨哥来到了青岩古镇的密室逃脱。在密室逃脱中有 N 个房间排成一排，
每个房间放有一张卡片，卡片上写着一个数字，参与者只有选择其中连续一段房间（不能不选），
进入完成挑战，才能看到卡片上的数字。最终，如果参与者能够准确的计算出所有进入房间的卡片数字之和，
那么他就可以逃脱密室。然而，小杨哥胆子很小，导致他在完成挑战之后竟然忘记了卡片数字之和，
不过，幸运的是，小杨哥还记得他进入了多少个房间，所以他直接喊出了他进入房间的个数。请你计算，小杨哥可以逃脱密室的不同方案数。
输入格式:
第一行为一个整数 T (1 ≤ T ≤ 10⁵) 表示测试数据的组数。
每个测试数据第一行为一个整数 N (1 ≤ N ≤ 5 * 10⁵) 表示房间总个数。
接下来一行 N 个整数，第 i 个整数 aᵢ(-10⁹ ≤ aᵢ ≤ 10⁹) 表示第 i 个房间的卡片上的数字
输入数据保证 T 组数据中 N 的总和不超过 10⁶。
输出格式:
输出 T 行每行一个整数表示小杨哥有多少种选择的方法可以逃出密室。
 */
public class A {
	public static void main(String []arg) {
		Scanner scanner = new Scanner(System.in);
		int t , n;
		t = scanner.nextInt();
		
		while(t-->0) {
			n = scanner.nextInt();
			int [] nums = new int[n];
//			题意：连续区间的和==连续区间的长度
//			个可以使用前缀和
//			sum（a[i],a[i+1],a[i+2],……a[j]) = j-i+1;
//			上式子可以化为sum（a[i]-1,a[i+1]-1,a[i+2]-1,……a[j]-1) = 0
//			所以只需在修改过的数组的前缀和里遍历,遇见相同的数字,即可算一次成功
			
//			修改数组
			for (int i = 0; i < n; i++) {
				nums[i] = scanner.nextInt()-1;
			}
			
//			前缀和
			long [] pre = new long[n+1];
			for (int i = 1; i < n+1; i++) {
				pre [i] = pre[i-1]+nums[i-1];
			}
			
			long ans = 0;
			HashMap<Long, Integer> hashMap  = new HashMap<>();
			hashMap.put(0L, 1);
			for (int i = 1; i < n+1; i++) {
				if(hashMap.containsKey(pre[i])) {
					ans+=hashMap.get(pre[i]);
				}
				hashMap.put(pre[i],hashMap.getOrDefault(pre[i], 0)+1);
			}
			System.out.println(ans);
		}
	}
}
