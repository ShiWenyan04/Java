package LanQiao;

import java.util.Arrays;
import java.util.Scanner;

public class _109_SeparateExaminationVenue {
	static Scanner scanner = new Scanner (System.in);
	static int n = scanner.nextInt();
	static int m = scanner.nextInt();
	static int [][] nums = new int[n+1][n+1];//关系表
	static int [][] room = new int[n+1][n+1];//房间状态
	
	static int min = Integer.MAX_VALUE;//考场数量
	public static void main(String[] arg) {
		for(int i = 1 ; i <= m ; i ++) {
			int j = scanner.nextInt();
			int k = scanner.nextInt();
			nums[j][k] = 1;
			nums[k][j] = 1;
		}
		room[1][0] = 1;
		dfs(1, 1);
		System.out.println(min);
	}
	//h为第几个考生，kc为已经用了多少个考场
	public static void dfs(int h,int kc) {
		if(kc >= min) {//当前考场数目大于之前最小的数目，直接返回，不满足题意
			return ;//剪枝
		}
		if(h > n) {//更新
			min = kc;
		}else {
			for(int i = 1; i <= kc;i++) {
				//遍历已经用过的考场，查看考场是否有空位，
				//并且考场的考生是否与当前的人认识
				//i为考场号
				int k = 0;//k为考场的座位
				while( room[i][k]!=0 && nums[h][room[i][k]] == 0) {//当i考场第k个位置有人时，并且h这个考生和这个位置的人不认识
					k++;//就遍历下一个座位
				}
				if(room[i][k] == 0) {//如果这个位置没有人
					room[i][k] = h;//那么这个人可以坐在这个考场
					dfs(h+1,kc);//递归下一个人
					room[i][k] =0;
				}
			}
			//以上条件都尝试过之后，如果不满足，就只能去下一个考场
			room[kc+1][0] = h;
			dfs(h+1, kc+1);
			room[kc+1][0] = 0;
		}
	}
}
