package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//有效字符串需满足：左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。每个右括号都有一个对应的相同类型的左括号。
//示例 1：
//输入：s = "()"
//输出：true
//示例 2：
//输入：s = "()[]{}"
//输出：true
//示例 4：
//输入：s = "([])"
//输出：true
public class _020_ValidParentheses {
    public static void main(String[] args) {
        String s = "){";
        System.out.println(Method(s));
    }
    public static boolean Method(String s){
        Deque<Character> deque = new ArrayDeque<>();
        int i =0;
        if (s.length()<2){
            return false;
        }
        while(i < s.length()){//利用栈，遇见左括号就存，s.chartAt(i)与栈顶匹配，则可去除栈顶，若不匹配，存入栈顶，合理的括号字符串最终会使栈为0
           if ( !deque.isEmpty()&&s.charAt(i) ==')' && deque.peek() == '('){//匹配小括号
                deque.pop();
            }else if (!deque.isEmpty()&& s.charAt(i) =='}' && deque.peek() == '{'){//匹配大括号
                deque.pop();
            }else if (!deque.isEmpty()&& s.charAt(i) ==']' && deque.peek() == '[') {//匹配中括号
                deque.pop();
            }else {//其余情况均存入
               deque.push(s.charAt(i));
           }
            if (deque.isEmpty() && i ==s.length()-1){//栈为0，则true
                return true;
            }
            i++;
        }
        return false;
    }
}
