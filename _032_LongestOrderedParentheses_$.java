package LeetCode;
//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//示例 1：
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
//示例 2：
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//示例 3：
//输入：s ="()(())"
//输出：6
public class _032_LongestOrderedParentheses_$ {
    public static void main(String[] args) {
        String s ="()(())";
        System.out.println(Method1(s));
    }
    public static int Method1(String s){
        Deque<Integer> deque = new ArrayDeque<>();
        int length = 0;
        deque.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){//对于遇到的每个 ‘(’ ，我们将它的下标放入栈中
                deque.push(i);
            }else {//对于遇到的每个 ‘)’ ，我们先弹出栈顶元素表示匹配了当前右括号：
                deque.pop();
                if (deque.isEmpty()) {//如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
                    deque.push(i);
                }else {//如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
                    length = Math.max(length,i-deque.peek());
                }
            }
        }
        return length;
    }
}
