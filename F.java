package oj7_6_6;


import java.util.Arrays;
import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 曼哈顿距离 |x1 - x2| + |y1 - y2| 可以拆分为以下四种情况的最大值：
(x + y) - (x + y)
(x - y) - (x - y)
(-x + y) - (-x + y)
(-x - y) - (-x - y)
因此，最大曼哈顿距离一定是以下两种情况之一：
(x + y) 的最大值 - (x + y) 的最小值
(x - y) 的最大值 - (x - y) 的最小值 */
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int [][]nums = new int [n][2];
		for (int i = 0; i < n; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			nums[i][0]=x+y;
			nums[i][1]=x-y;
		}
//		找x+y最大值最小值，x-y最小值最大值
		int maxx = 0;
		int minx = Integer.MAX_VALUE;
		int miny = Integer.MAX_VALUE;
		int maxy = 0;
		for (int i = 0; i < n; i++) {
			maxx = Math.max(maxx, nums[i][0]);
			minx = Math.min(minx, nums[i][0]);
			miny = Math.min(miny, nums[i][1]);
			maxy = Math.max(maxy, nums[i][1]);
		}
		
		System.out.println(Math.max(maxx-minx, maxy-miny));
	}

}
