package LeetCode;


import java.util.HashSet;

public class _2829_minimumSum {
	public static void main(String[] arg) {
		int n = 5,k = 4;
		System.out.println(Method(n,k));
		System.out.println(Method2(n, k));
	}
	public static int Method(int n, int k) {
		int []nums = new int [n];
		int sum = 0;
		HashSet<Integer> hashSet = new HashSet<Integer>();
		int num = 1;
		for (int i = 0; i < n; i++,num++) {
			while(hashSet.contains(num)) {
				num++;
			}
			nums[i] = num;
			sum+=num;
			hashSet.add(k-num);
		}
		return sum;
	}
	public static int Method2(int n,int k) {
		int temp = k/2;
		int sum = 0;
		int num = 1;
		for (int i = 0; i < n; i++,num++) {
			if(num <= temp) {
				sum+=num;
			}else {
				sum+=k;
				k++;
			}
		}
		return sum;
	}
}
