package LeetCode;

import ShiYan6_2.Method;

import java.util.ArrayList;
import java.util.List;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//示例 1：
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//示例 2：
//输入：n = 1
//输出：["()"]
public class _022_1_BracketsGenerated {
    public static void main(String[] args) {
        int n = 1;
        List<String> list = new ArrayList<>();
        Method(list, n, 0,0, "");
        System.out.println(list);
    }
    public static void Method(List<String> list, int n, int left,int right, String str){
        if (left == n && right == left ){//左、右括号相等且等于n
            list.add(str);
            return;
        }
        if (left < n ){//左括号小于n时，就可以再加一个左括号
            Method(list,n,left+1,right,str+"(");
        }
        if (right < left){//有多少个左括号就有多少个右括号
            Method(list,n,left,right+1,str+")");
        }
    }
}
