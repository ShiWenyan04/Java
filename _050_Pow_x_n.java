package LeetCode;
//实现 pow(x, n) ，即计算 x 的整数 n 次幂函数。
//示例 1：
//输入：x = 2.00000, n = 10
//输出：1024.00000
//示例 2：
//输入：x = 2.10000, n = 3
//输出：9.26100
//示例 3：
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
public class _050_Pow_x_n {
    public static void main(String[] args) {
        double x  = 2.00000;
        int n = -2;
        double result = 1.0;
        if (n == 0 || x==1 ){//幂为0或底为1
            System.out.println(1.0);;
        }
        if (n < 0){//n<0只需按照n>0的步骤计算结果，最后用1除
            result = 1/Method(x,-n,result);
        }else {//n>0的步骤
            result = Method(x,n,result);
        }
        System.out.println(result);
    }
    public static double Method(double x, int n, double result){//不断把n拆解，分成无数个2，倘若为奇数，就在无数个2之后再乘x
        if(n == 0){//拆解n到最后的步骤，返回后n=1，为奇数幂算法，以此类推
            return 1.0;
        }
        result = Method(x,n/2,result);//不断拆分n

        if (n%2 == 0){//次数为偶次幂
            return result*result;
        }else {//次数为奇次幂，只需比偶次幂多乘一次x
            return result*result*x;
        }
    }
}
