package LeetCode;

import ShiYan6_2.Method;

public class _2466_countGoodStrings {
    public static void main(String[] args) {
        int low = 3, high = 3, zero = 1, one = 1;
        System.out.println(Method(low,high,zero,one));
    }
    public static int Method(int low,int high,int zero,int one){
        int []f = new int[high+1];
        int mod = 100000007;
        f[0] = 1;
        int ans = 0 ;
        for (int i = 1; i <= high; i++) {
            if(i-zero >= 0){
                f[i] = f[i-zero];
            }
            if (i-one >= 0) {
                f[i] = (f[i] + f[i-one])%mod;
            }
            if(i > low){
                ans = (ans+f[i])%mod;
            }
        }
        return f[high];
    }
}
