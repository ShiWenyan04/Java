package LeetCode;
//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
//注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5

//示例 1：
//输入：x = 4
//输出：2

//示例 2：
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
public class _069_Square {
    public static void main(String[] args) {
        int x =2147395599;
        System.out.println(Method(x));
    }
    public static int Method(int x){
        int left = 1, right = (x/2);//x开根后的值肯定小于x/2
        int  mid;
        if (x == 1||x==0){
            return x;
        }
        while(left <= right){
            mid = (left + right) / 2 ;
            int temp = x / mid ;
            if ( mid < temp ) {//相当于 mid*mid<x
                left = mid + 1; //  区间向大值区域缩进
            }if (mid == temp ){
                return mid ;
            }if (mid > temp ){//相当于 mid*mid>x
                right = mid - 1;//区间向小值区域缩进
            }
        }
        return left - 1;
    }
}
