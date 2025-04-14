package LeetCode;

import sun.misc.PostVMInitHook;

import java.util.ArrayDeque;
import java.util.Deque;

//给你一个只包含三种字符的字符串，支持的字符类型分别是 '('、')' 和 '*'。请你检验这个字符串是否为有效字符串，如果是 有效 字符串返回 true 。
//有效 字符串符合如下规则：
//任何左括号 '(' 必须有相应的右括号 ')'。
//任何右括号 ')' 必须有相应的左括号 '(' 。
//左括号 '(' 必须在对应的右括号之前 ')'。
//'*' 可以被视为单个右括号 ')' ，或单个左括号 '(' ，或一个空字符串 ""。
//示例 1：
//输入：s = "()"
//输出：true
//示例 2：
//输入：s = "(*)"
//输出：true
//示例 3：
//输入：s = "(*))"
//输出：true
public class _0678_ValidParentheticalStrings {
    public static void main(String[] args) {
        String s = "(*))";
        System.out.println(Method(s));
    }
    public static boolean Method(String s){
        Deque<Integer> deque = new ArrayDeque<>();//存放左括号的索引值
        Deque<Integer> deque2 = new ArrayDeque<>();//存放*的索引值
        for (int i = 0; i < s.length(); i++) {//思路：左括号存入左栈，遇见*就存*栈，遇见右括号，先匹配左括号，左括号匹配完再匹配*
            if(s.charAt(i) == '(' ){
                deque.push(i);
            }else if(s.charAt(i) == '*'){
                deque2.push(i);
            }else {
                if(!deque.isEmpty()){
                    deque.poll();
                }else if(!deque2.isEmpty()) {
                    deque2.pop();
                }else return false;
            }
        }
        while(!deque.isEmpty() && !deque2.isEmpty()) {//当字符串遍历完毕，左括号和*匹配，一定保证左括号的索引值小于*的索引值，这样*才能充当右括号，*剩余，可以当作空格处理
            if (deque.pop() > deque2.pop()){
                return false;
            }
        }
        return deque.isEmpty();//如果是左括号剩余，说明*和右括号的数量加起来小于左括号
    }
}
