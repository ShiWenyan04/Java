package LanQIao_2023_Guo;


import java.util.Scanner;

public class _2 {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		String [] nums = {"1111110","0110000","1101101"	,"1111001","0110011","1011011","1011111","1110000","1111111","1111011"};
		Scanner scanner = new Scanner (System.in);
		String [] strs = new String [18];
		int [] c = new int [18];//记录18位数字每位数字可以变换的个数
//		现挨个输入18个数字
		for (int i = 0; i < 18; i++) {
			strs[i] = scanner.next();
			
		}
		for(int i = 0 ; i < 18 ; i ++) {
			String str1 = strs[i];
			int cnt = 0;
//			遍历0-9得数字，
			for (int j = 0; j < nums.length; j++) {
				String str2 = nums[j];
//			每一位进行对比
				int k = 0;
				for (; k < str2.length(); k++) {
//					如果str1的k位为 1 ，那么str2 的k位也必须为1
//					str1的k位为0，那str2的k位可以是1 也可是0
					if(str1.charAt(k) == '1' && str2.charAt(k) == '0') {
						break;//比下一个0-9的数字
					}
				}
				if( k == str2.length()) {//可以变成0-9的数字的个数
					cnt++;
				}
			}
			c[i]=(cnt);
		}
		int ans = 1;
		for(int i = 0; i <c.length;i++) {
			ans*=c[i];
		}
		System.out.println(ans);
	}
}
