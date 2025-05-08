package Java_Big_Text;

import java.util.Scanner;
//给定一个数列a1,a2,a3,a4……，找出一个子序列，确保i<j,并且ai<aj，求出最长连续子序列的长度（不一定要连续）
public class _shiti {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String []input = sc.nextLine().split(" ");
        int [] nums = new int [input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        int maxLength = Len(nums);
        System.out.println(maxLength);

    }
    public static int Len (int []nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int []dp = new int [nums.length];
        int max = 1;
        for(int i = 0; i < nums.length;i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
