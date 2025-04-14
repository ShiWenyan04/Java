package LeetCode;

import java.util.ArrayList;
import java.util.List;

//给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump 。一开始，你在下标 0 处，且该位置的值一定为 '0' 。当同时满足如下条件时，你可以从下标 i 移动到下标 j 处：
//i + minJump <= j <= min(i + maxJump, s.length - 1) 且
//s[j] == '0'.
//如果你可以到达 s 的下标 s.length - 1 处，请你返回 true ，否则返回 false 。
//示例 1：
//输入：s = "011010", minJump = 2, maxJump = 3
//输出：true
//解释：
//第一步，从下标 0 移动到下标 3 。
//第二步，从下标 3 移动到下标 5 。
//示例 2：
//输入：s = "01101110", minJump = 2, maxJump = 3
//输出：false
public class _1871_JumpingGame_VII_$ {
    public static void main(String[] args) {
        String s =  "01000110110";
        int min = 2,max = 3;
        System.out.println(Method(s,min,max));
    }
    public static boolean Method(String s,int min , int max){
        if(s.charAt(s.length()-1) != '0') return false;
        int len = s.length();
        for(int i = 0; i < len;i++){
            if( len-1>= i + min && len-1 <= Math.min(i+max,len-1)){
                return true;
            }
            List<Integer> list = Method2(s,i+min,Math.min(i+max,len-1));
            if (list.isEmpty()) return false;
            for (int j = list.size()-1; j >= 0 ;j-- ) {
                if (len-1-list.get(j) >= min ) {
                    i = list.get(j) - 1;
                    break;
                }else if (j == list.size()-1) return false;
            }
        }
        return false;
    }
    public static List<Integer> Method2(String s, int start, int end){
        List<Integer> list = new ArrayList<>();
        int j = 0;
        for (int i = start; i <= end; i++) {
            if(s.charAt(i) == '0'){
                list.add(i);
                j++;
            }
        }
        return list;
    }
}
