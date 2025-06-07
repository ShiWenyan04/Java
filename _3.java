package LanQIao_2023_Guo;

import java.util.Scanner;
/*小蓝有一个整数 n。每分钟，小蓝的数都会发生变化，变为上一分钟的数减去上一分钟的数的各个数位和。 
 例如，如果小蓝开始时的数为 $23$，则下一分钟变为 $23 - (2 + 3) = 18$，再下一分钟变为 
 18 - (1 + 8) = 9，再下一分钟变为 9 - 9 = 0，共经过了 3 分钟变为 0。
  给定一个正整数，请问这个数多少分钟后变为 0
 */

public class _3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int cnt = 0;
//		暴力
		
		while(n!=0) {
			cnt++;
			String string = String.valueOf(n);
			int sum = 0;
//			各个位数相加
			for (int i = 0; i < string.length(); i++) {
				sum+=string.charAt(i)-'0';
			}
			 n = n-sum;
		}
		System.out.println(cnt);
	}

}
