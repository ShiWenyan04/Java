package LanQiao_2024_Guo;


import java.util.Scanner;

public class _3 {
	public static void main(String[] arg) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int Base[] = {2,4,8,16};//进制
		while( n >0) {
			int count = 0;
			long ans = -1; ;
			
			String a = scanner.next();
			long b = scanner.nextInt();
			
			for(int base : Base) {//遍历进制
				try {
					long num = Long.parseLong(a,base);//转换
					if(num <= b) {//满足条件，个数加一
						count++;
						ans = num;
					}
				}catch (Exception e) {
					continue;
				}
			}
			
			if(count  == 1) {//如果个数等于1
				System.out.println(ans);
			}else {
				System.out.println(-1);
			}
			n--;
		}
	}
}
