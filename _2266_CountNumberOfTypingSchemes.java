package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2266_CountNumberOfTypingSchemes {
    public static void main(String []arg){
        String p = "444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664";
        System.out.println(Method(p));
    }
    public static int Method(String p){
        int n = p.length();
        int mod = 1000000007;
        List<Long> button3 = new ArrayList<>(Arrays.asList(1L,1L,2L,4L));
        List<Long> button4 = new ArrayList<>(Arrays.asList(1L,1L,2L,4L));
        for (int i = 4; i <= n; i++) {
            button3.add((button3.get(i-1)+button3.get(i-2)+button3.get(i-3)) % mod);//利用动态规划，计算有三个字母的按键连续按n次有多少种
            button4.add((button4.get(i-1)+button4.get(i-2)+button4.get(i-3)+button4.get(i-4)) % mod);//利用动态规划，计算有四个字母的按键连续按n次有多少种
        }
        int count = 1;
        long res = 1;
        for (int i = 1; i < n; i++) {
            if(p.charAt(i)==p.charAt(i-1)){//计算连续相同的按键的个数
                count++;
            }else {
                if(p.charAt(i-1) == '7'||p.charAt(i-1)=='9'){//判断连续按键的类型是四个字母的按键（7，9）or三个字母的按键（2，3，4，5，6，8）
                    res=(res*button4.get(count))%mod;//乘以当前按键所有情况
                }else {
                    res=(res*button3.get(count))%mod;//乘以当前按键所有情况
                }
                count = 1;
            }
        }
        if(p.charAt(n-1) =='7'|| p.charAt(n-1)=='9'){//因为上个循环提前跳出，只需判断最后一个按键类型，进行判断计算即可
            res=(res*button4.get(count))%mod;
        }else {
            res=(res*button3.get(count))%mod;
        }
        return (int)res;
    }
}
