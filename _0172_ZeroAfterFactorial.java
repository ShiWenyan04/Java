package LeetCode;
//给定一个整数 n ，返回 n! 结果中尾随零的数量。
//提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
//示例 1：
//输入：n = 3
//输出：0
//解释：3! = 6 ，不含尾随 0
//示例 2：
//输入：n = 5
//输出：1
//解释：5! = 120 ，有一个尾随 0
public class _0172_ZeroAfterFactorial {
    public static void main(String[] args) {
        int n = 31;
        System.out.println(Method(n));
    }
    public static int Method(int n){
        int ans = 0;
        // 每一次循环都整除 5，这样就能满足 5、25、125
        for (int i = n; i / 5 > 0 ; i = i/5) {
            // 得到每一轮因子 5 的个数
            ans +=i/5;
        }
        return ans;
    }
}
