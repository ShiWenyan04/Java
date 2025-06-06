package oj7_6_6;

import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		int d = scanner.nextInt();
		
//		第一种情况： ab小于0，但是cd大于0
		if(b <= 0 && c >=0) {
			System.out.println((long)b*c);
		}else if( b >= 0 && d >= 0){
//			第二种情况： a<0，b>0，c<0,d>0
			System.out.println(Math.max((long)b*d, (long)a*c));
		}else if (a >= 0 && d <= 0) {
//			第三种情况：ab大于0，cd小于0
			System.out.println((long)a*d);
		}else {
			System.out.println((long)a*c);
		}
	}
}
