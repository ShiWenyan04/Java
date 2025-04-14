package LeetCode;
//给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10n 。
//示例 1：
//输入：n = 2
//输出：91
//解释：答案应为除去 11、22、33、44、55、66、77、88、99 外，在 0 ≤ x < 100 范围内的所有数字。
//示例 2：
//输入：n = 0
//输出：1
public class _0357_CountNumber {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Method(n));
    }
    public static int Method(int n){
        if (n == 0){
            return 1;
        } else if (n==1) {//位数为一，答案有0~9共十个
            return 10;
        }
        int ans = 9;
        int nums[] = new int[n];//nums分别记录位数为1，2，3，4，5……的答案
        nums[0] = 10;//位数为1时，答案有0~9共十个，故存入数组nums第一位
        for (int i = 0; i < n-1; i++) {
            ans *= (Method2(9-i))/(Method2(9-i-1));//计算出n位数的答案，用排列组合计算
            nums[i+1] = ans + nums[i];//n位数的答案加上小于几位数的答案，就是1~10的n次方的答案
        }
        return nums[nums.length-1];
    }
    public static int Method2(int k){//阶乘计算
        int j = 1;
        for (int i = 0; i < k; i++){
            j= j * (i+1);
        }
        return j;
    }
}
