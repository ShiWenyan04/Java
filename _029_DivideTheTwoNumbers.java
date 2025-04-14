package LeetCode;

import java.util.ArrayList;
import java.util.List;

//给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
//整数除法应该向零截断，也就是截去（truncate）其小数部分。例如，8.345 将被截断为 8 ，-2.7335 将被截断至 -2 。
//返回被除数 dividend 除以除数 divisor 得到的 商 。
//注意：假设我们的环境只能存储 32 位 有符号整数，其数值范围是 [−231,  231 − 1] 。本题中，如果商 严格大于 231 − 1 ，则返回 231 − 1 ；如果商 严格小于 -231 ，则返回 -231 。
//示例 1:
//输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = 3.33333.. ，向零截断后得到 3 。
public class _029_DivideTheTwoNumbers {
    public static void main(String[] args) {
        int dividend = -2147483648, divisor = -1109186033;
        System.out.println(Method(dividend,divisor));
    }
    public static int Method(int dd,int ds){
        // 考虑被除数为最小值的情况
        if (dd == Integer.MIN_VALUE) {
            if (ds == 1) {
                return Integer.MIN_VALUE;
            }
            if (ds == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (ds == Integer.MIN_VALUE) {
            return dd == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数为 0 的情况
        if (dd == 0) {
            return 0;
        }
// 一般情况，使用类二分查找
        // 将所有的负数数取相反数，这样就只需要考虑一种情况
        boolean rev = false;
        if(ds>0 && dd > 0 || ds < 0 && dd <0){
            rev = true;
        }
        if (ds < 0) {
            ds = -ds;
        }
        if (dd < 0) {
            dd = -dd;
        }
        int ans = 0; // 存储最终结果
        List<Integer> list = new ArrayList<>(); // 存储当前除数的倍数
        int index = 0;
        list.add(ds); // 将除数添加到 list 中

        // 生成除数的倍数，类似于二分查找方式，不断加倍
        while (list.get(index) >= dd - list.get(index)) {
            list.add(list.get(index) + list.get(index)); // 当前倍数加倍
            index++;
        }

        // 根据二分查找的倍数来逐步计算商
        for (int i = list.size() - 1; i >= 0; i--) {
            // 从最大倍数开始，如果当前倍数可以从 dd 中减去，则将该倍数加入结果
            if (list.get(i) >= dd) {
                ans += 1 << i; // 通过位移来表示该倍数
                dd -= list.get(i); // 更新被除数
            }
        }

        // 如果除数和被除数符号相同，结果为正，否则为负
        return rev ? ans : -ans;
    }
//    初始化：
//dd = -20, ds = 3
//将 dd 和 ds 都转为负数：dd = -20, ds = -3
//rev 被设置为 true，因为 -20 和 -3 同号。

//    计算倍数并存入list

//    计算商：
//接着进入计算商的阶段：
//从 list 的最后一个元素开始：
//list[3] = -24 不满足条件 -24 >= -20
//list[2] = -12 满足条件 -12 >= -20，于是 ans += 1 << 2 = 4，更新 dd：
//ans = 4, dd = -20 - (-12) = -8
//list[1] = -6 满足条件 -6 >= -8，于是 ans += 1 << 1 = 2，更新 dd：
//ans = 6, dd = -8 - (-6) = -2
//list[0] = -3 不满足条件 -3 >= -2
}
