package LeetCode;
//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
//给定 n ，请计算 F(n) 。
//示例 1：
//输入：n = 2
//输出：1
//示例 2：
//输入：n = 3
//输出：2
//示例 3：
//输入：n = 4
//输出：3
public class _0509_Fibonacci {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(Method(n));
    }
    public static int Method(int n){
        int f0 = 0,f1 = 1;
        int f = 1;
        if (n==0){
            return n;
        }
        for (int i = 2; i < n+1; i++) {
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        return f;
    }
}
