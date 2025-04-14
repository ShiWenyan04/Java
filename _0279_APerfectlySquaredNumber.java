package LeetCode;

public class _0279_APerfectlySquaredNumber {
    public static void main(String []arg){
        int n = 12;
        System.out.println(Method(n));
    }
    public static int Method(int n){
        if(isPerfect(n)){//当这个数本身即为完全平方数，返回1
            return 1;
        }
//        四平方和定理证明了任意一个正整数都可以被表示为至多四个正整数的平方和，给出答案的范围在1~4
//        当 n=4^k×(8m+7) 时,答案为4；
        if (isPerfect4(n)){//当这个数满足
            return 4;
        }
//        当 n!=4^k×(8m+7) 时，答案范围在1~3;而以上的if判断排除答案1，以下的for循环分析答案2，如果两个答案均不满足，直接返回3；
        for (int i = 1; i*i <= n; i++) {
            int j = n-i*i;
            if(isPerfect(j)){
                return 2;
            }
        }
        return 3;
    }

    //    判断是否是完全平方数
    public static boolean isPerfect(int n){
        int x = (int)Math.sqrt(n);
        return x*x==n;
    }
    // 判断是否能表示为 4^k*(8m+7)
    public static boolean isPerfect4(int n){
        while(n%4 == 0){
            n/=4;
        }
        return n%8 == 7;
    }
}
