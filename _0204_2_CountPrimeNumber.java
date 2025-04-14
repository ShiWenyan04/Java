package LeetCode;
//给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
//示例 1：
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
public class _0204_2_CountPrimeNumber {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Method(n));
    }
    public static int Method(int n){
        if(n <=2){
            return 0;
        }
        int number = 0;
        for (int i = 2; i <= n; i++) {
            if (Prime(i)){
                number++;
            }
        }
        return number;
    }
    public static boolean Prime(int num){
        for (int i = 2; i*i <= num; i++) {
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
