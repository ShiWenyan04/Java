package LeetCode;

import java.util.Arrays;

//我们设 isPrime[i] 表示数 i 是不是质数，如果是质数则为 1，否则为 0
public class _0204_1_CountPrimeNumber {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(Method(n));
    }
    public static int Method(int n){
        int ans =0;
        boolean []isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            if(!isPrime[i]){//当前数为质数
                ans+=1;
                //当前数为质数时，那么它的倍数都为合数
                // 并且在统计合数时，可以从i*i开始统计，因为在此之前的合数都已经被前一个指数的倍数统计过了
                if((long) i*i < n){
//              避免溢出
//              在筛选素数时，从 i * i 开始标记所有 i 的倍数为非素数。如果开始标记的数都超过n，说明后面没有合数
                    for (int j = i*i; j < n ; j+=i) {
                        isPrime[j] = true;
                    }
                }
            }
        }
        return ans;
    }
}
