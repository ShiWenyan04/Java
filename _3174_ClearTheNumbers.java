package LeetCode;

import ShiYan6_2.Method;

import java.util.Deque;
import java.util.LinkedList;

//给你一个字符串 s 。
//你的任务是重复以下操作删除 所有 数字字符：
//删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
//请你返回删除所有数字字符以后剩下的字符串。
//示例 1：
//输入：s = "abc"
//输出："abc"
//示例 2：
//输入：s = "cb34"
//输出：""
//解释：
//一开始，我们对 s[2] 执行操作，s 变为 "c4" 。
//然后对 s[1] 执行操作，s 变为 "" 。
public class _3174_ClearTheNumbers {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(Method(s));
    }
    public static String Method(String s) {
            int n = s.length ();
            Deque<String> deque = new LinkedList<>();
            for (int i = 0;i < n;i++){//按正序将s存入deque
                if (!Character.isDigit (s.charAt(i))){//不是数字就存
                    deque.push(s.substring(i,i+1));
                }else deque.poll();//是数字就将前一个deque的值删除
            }
            s = "";
            while (!deque.isEmpty()){//循环输出deque的值
                s+= deque.getLast();
                deque.pollLast();
            }
            return s;
    }
}
