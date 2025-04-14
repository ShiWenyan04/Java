package LeetCode;

import java.util.ArrayList;
import java.util.List;

//累加数 是一个字符串，组成它的数字可以形成累加序列。
//一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，序列中的每个后续数字必须是它之前两个数字之和。
//给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。
//说明：累加序列里的数，除数字 0 之外，不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。
//示例 1：
//输入："112358"
//输出：true
//解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
//示例 2：
//输入："199100199"
//输出：true
//解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199
public class _0306_CumulativeNumber_$ {
    public static void main(String[] args) {
        String s = "199100199";
        List<Integer> com = new ArrayList<>();
        System.out.println();
    }
    public static boolean Method(String s, List<Integer> com){
        int len = com.size();
        if (com.size() >= 3 && com.get(len-1) != com.get(len-2) + com.get(len-3)){
            return false;
        }
        if(s.length()==0 && len>=3){
            return true;
        }
        return false;
    }
}
