package LeetCode;

public class _0263_isUgly {
    public static void main(String []arg){
        int n = 6;
        System.out.println(Method(n));
    }
    public static boolean Method(int n){
        if(n<=0){
            return false;
        }
        if(n == 1){
            return true;
        }
        int []nums = {2,3,5};
        for (int i = 0; i < 3; i++) {
            while(n % nums[i] == 0){//不断除以2，3，5，判断能否除尽
                n/=nums[i];
            }
        }
        return n==1;//最后结果为1，则是丑数
    }
}
