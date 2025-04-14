package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
//
//
//示例 1 ：
//
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
//示例 2 ：
//
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
//示例 3 ：
//
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
public class _0402_Remove_K_digitNumber {
    public static void main(String[] args) {
        String num ="10200";
        int k = 1;
        System.out.println(Method(num,k));
    }
    public static String Method(String num,int k){
        if(num.length() == k){
            return "0";
        }
        Deque<Character> deque = new ArrayDeque<>();
        int i = 0;
        char ch ;
        while (i != num.length()){//遍历，存入deque的值，确保左边的数字严格小于右边，就能在去除k次以后获得最小的数
            ch = num.charAt(i);
            while (i != 0 && !deque.isEmpty() &&  k > 0 && deque.peek() > ch ){//一旦遇见比之前存的数字小的值，就删除之前村的数字，直到栈顶的值小于当前值
                deque.pop();
                k--;
            }
            deque.push(ch);
            i++;
        }

        for (int j = 0; j < k; ++j) {//因为去除很多次后，已经获得了严格意义上的升序，倘若去除的数字的个数没达到k，那么去除最后一个数字即为最小值（升序）
            deque.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){//转换成字符串
            sb.append(deque.pollLast());
        }
        int j = 0;
        String str = sb.toString();
        String ans = str;
        while( j < str.length() && str.charAt(j) == '0') {//去除前导零
            ans = str.substring(++j);
        }
        return ans.isEmpty() ?"0":ans;
    }
}
