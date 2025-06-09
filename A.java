package ICPC_XiAn;

import java.util.HashMap;
import java.util.Scanner;

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
