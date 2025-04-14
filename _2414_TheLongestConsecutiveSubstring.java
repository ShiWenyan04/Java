package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

//字母序连续字符串 是由字母表中连续字母组成的字符串。换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连续字符串 。
//例如，"abc" 是一个字母序连续字符串，而 "acb" 和 "za" 不是。
//给你一个仅由小写英文字母组成的字符串 s ，返回其 最长 的 字母序连续子字符串 的长度。
//示例 1：
//输入：s = "abacaba"
//输出：2
//解释：共有 4 个不同的字母序连续子字符串 "a"、"b"、"c" 和 "ab" 。
//"ab" 是最长的字母序连续子字符串。
//示例 2：
//输入：s = "abcde"
//输出：5
//解释："abcde" 是最长的字母序连续子字符串。
public class _2414_TheLongestConsecutiveSubstring {
    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(Method(s));
    }
    public static int Method(String s){
        Deque<Integer> deque = new ArrayDeque<>();
        int i = 0, preAns = 0,ans = 0;
        while(i < s.length()){//利用栈
            if (deque.isEmpty() || deque.peek()==(int)s.charAt(i)-1){//栈为空，或字母连续就保存并计数
                deque.push((int) s.charAt(i));
                preAns++;
            }else {//字母不连续清空重新计数
                ans = Math.max(ans,preAns);
                deque.removeAll(deque);
                preAns = 0;
                i--;
            }
            if (i == s.length()-1){//达到长度后直接返回最大值
                ans = Math.max(ans,preAns);
                return ans;
            }

            i++;
        }
        return ans;
    }
}
