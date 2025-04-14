package LeetCode;

import java.util.ArrayList;
import java.util.List;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//示例 1：
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//示例 2：
//输入：n = 1
//输出：["()"]
public class _022_2_BracketsGenerated$ {
    public static void main(String[] args) {
        int n = 3;
        List<String> list = new ArrayList<>();
        Method(list, n, n, "");
        System.out.println(list);
    }
    public static void Method(List<String> list , int left, int right, String curStr){
        if (left == 0 && right == 0){ // 左、右括号都不剩余了，递归终止
            list.add(curStr);
            return;
        }
        if (left>0){// 如果左括号还剩余的话，可以拼接左括号
            Method(list,left-1,right,curStr+"(");
        }
        if (right>left){// 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            Method(list,left,right-1,curStr+")");
        }

    }
}
