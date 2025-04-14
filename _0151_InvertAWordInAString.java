package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

//给你一个字符串 s ，请你反转字符串中 单词 的顺序。
//单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
//返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
//注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
//示例 1：
//输入：s = "the sky is blue"
//输出："blue is sky the"
//示例 2：
//输入：s = "  hello world  "
//输出："world hello"
//解释：反转后的字符串中不能存在前导空格和尾随空格。
public class _0151_InvertAWordInAString {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(Method(s));
    }
    public static String Method(String s){
        StringTokenizer st = new StringTokenizer(s," ");//切割字符串
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        while (st.hasMoreElements()){//存入数组
            list.add(st.nextToken());
        }
        int i = list.size()-1;
        while(i >= 0){//倒叙输出
            sb.append(list.get(i));
            if(i != 0){//除了末尾单词，别的单词后面都加空格
                sb.append(" ");
            }
            i--;
        }
        return sb.toString();
    }
}
