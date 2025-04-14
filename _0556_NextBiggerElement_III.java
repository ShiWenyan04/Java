package LeetCode;

import java.util.Arrays;

//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
//注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
//示例 1：
//输入：n = 12
//输出：21
//示例 2：
//输入：n = 21
//输出：-1
public class _0556_NextBiggerElement_III {
    public static void main(String[] args) {
        int n =2147483486;
        System.out.println(Method1(n));
    }
    public static int Method1(int n){
       char[] ch = String.valueOf(n).toCharArray();
       int i = ch.length-2;
       while(i>=0 && ch[i] >= ch[i+1]){//逆序寻找第一个小于后者的数，为a
           i--;
       }
       if(i < 0){
           return -1;
       }
       int j = ch.length-1;
       while (j >= 0 && ch[j]<=ch[i]){//逆序寻找第一个大于a的数，为b
           j--;
       }
       swap(ch,i,j);//交换ab
       reverse(ch,i+1);//ab内的数字排序最小
       long ans = Long.parseLong(new String(ch));
       return ans>Integer.MAX_VALUE ? -1:(int)ans;
    }
//    交换函数
    public static void swap(char[] num , int i , int j){
        char temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
//    在已经划分的区域里将元素重组，排成最小值
    public static void reverse(char[] num,int start){
        int end = num.length-1;
        while (start<end){
            swap(num,start,end);
            end--;
            start++;
        }
    }
}
