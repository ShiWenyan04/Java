package LanQiao_2024_Guo;

import java.util.Arrays;
import java.util.Scanner;
/* 给定一个 n 位的没有前导零的十进制数 m，你可以将其任意位 a i改为任意其它数字 b i，
 * 花费为 ∣b i−a i ∣。我们希望通过最少的花费使得修改后的数中存在连续的 10 位，
 * 包含了从 0 到 9 的所有数字，且每个数字恰好出现一次。
请输出最少需要的花费是多少（修改后也要求没有前导零）。*/
public class _5 {
	public static void main(String[] arg) {
		Scanner scanner = new Scanner(System.in);
		int min = Integer.MAX_VALUE;
		String m = scanner.next();
		for(int i = 0; i < m.length()-9 ;i++) {
			int a[] = new int [10];// 创建一个长度为 10 的数组，用来存储当前子字符串的数字
			for(int j = 0;j < 10;j++) {
				a[j] = m.charAt(i+j)-48;  // 将子字符串中的每个字符转为数字
			}
		
			Arrays.sort(a);  // 对数组 a 进行排序
			int now = 0;// 初始化当前修改花费
			for(int j = 0 ; j < 10 ; j++) {
				now+=Math.abs(j-a[j]);// 计算当前子字符串的数字与 0 到 9 的数字的花费
			}
			if(min > now) {// 如果当前的修改花费比最小花费还小，更新 min
				min = now;
			}
		}
	System.out.println(min);
	}
}
