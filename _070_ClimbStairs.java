package LeetCode;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//示例 1：
//输入：n = 2
//输出：2
//示例 2：
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
public class _070_ClimbStairs {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(Method(n));
    }
    public static int Method(int n){
        int []f = new int[n+1];//f[i]是索引以i为结尾的阶梯的方法总和
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < n+1 ; i++) {//由于可以跨一阶、二阶，故两种情况之和加起来为当前阶梯的方法之和
            f[i] = f[i-1] + f[i-2];//当前阶梯可从前一阶梯跨一步，也可从前两阶梯跨两步，前一阶梯方法之和+前两阶梯方法之和 = 当前阶梯方法之和
        }
        return f[n];
    }
}
