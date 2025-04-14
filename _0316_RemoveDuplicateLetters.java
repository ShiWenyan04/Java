package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
//示例 1：
//输入：s = "bcabc"
//输出："abc"
//示例 2：
//输入：s = "cbacdcbc"
//输出："acdb"
public class _0316_RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(Method(s));
    }
    public static String Method(String s){
        char []chars = s.toCharArray();
        int [] index = new int[26];// index 数组记录每个字符在字符串中的最后出现位置
        // 遍历字符串，将每个字符的最后出现位置存入 index 数组5
        for (int i = 0; i < chars.length; i++) {
            index[chars[i] - 'a'] = i;
        }
        Deque<Character> deque = new ArrayDeque<>();
        boolean []visited = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            // 如果字符已经访问过，跳过当前字符
            if(visited[chars[i]-'a']){
                continue;
            }
            // 只要队列不为空，且队头的字符大于当前字符，并且队头字符之后还会再出现
            // 就将队头字符移除（栈的特性保证移除的是较小的字符）
            while(!deque.isEmpty() && deque.peek() > chars[i] && index[deque.peek()-'a']>i){
                char c = deque.pop();
                visited[c-'a'] = false;// 标记该字符已被移除，可以重新加入
            }
            deque.push(chars[i]);
            visited[chars[i] -'a'] = true;
        }
        // 从队列的尾部（即栈底）按顺序取出字符，构造最终字符串
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }
}
