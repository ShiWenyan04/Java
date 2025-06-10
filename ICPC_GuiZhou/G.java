package ICPC_GuiZhou;

import java.util.Arrays;
import java.util.Scanner;
/*
在青云路中，n (1 ≤ n ≤ 10⁶) 个摊位排成一排，每个摊位的食物都有一个美味度为 aᵢ（0 ≤ aᵢ ≤ 10⁹），
来青云路的游客总是从第一个摊位开始依次走到最后一个摊位，如果当前面对的这个摊位还有食物，
并且没有其他摊位的食物的美味度比这个摊位的食物的美味度低，
那么他可以把这个摊位的食物买光吃掉，吃掉后这个摊位的食物将消失，再也不会出现。
打完贵州省赛，小杨哥很高兴的到了青云路，他想要尝完所有的食物，所以他想请你帮他算一算，
如果他吃掉所有的食物，他一共需要逛多少次街（逛一次街指第一个摊位走到最后一个摊位）。
输入格式:
第一行为一个整数 T (1 ≤ T ≤ 10⁴) 表示有 T 组测试数据。
每组测试数据第一行一个整数 n 表示一排有 n 个摊位。
第二行 n 个整数，第 i 个整数 aᵢ表示第 i 个摊位的所有食物的美味度。保证不存在 i，j 使得 i ≠ j 且 aᵢ = aⱼ
保证 T 组数据中 n 的总和不会超过 2 * 10⁶
输出格式:
输出 T 行。第 i 行一个整数表示第 i 组测试样例的答案。
 */
public class G {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		while(t > 0) {
			t--;
			int ans = 1;
			int n = scanner.nextInt();
			int[][] nums = new int[n][2];
//			输入数组到二维中，其中存放着数组一开始的位置
			for (int i = 0; i < nums.length; i++) {
				nums[i][0] = scanner.nextInt();
				nums[i][1] = i;
			}
			Arrays.sort(nums, (a, b) -> a[0] - b[0]);
			for(int i = 1; i < nums.length; i++) {
				if(nums[i][1] < nums[i-1][1]) {
					ans++;
				}
			}
			System.out.println(ans);
		}
	}
}
