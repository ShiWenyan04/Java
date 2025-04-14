package LeetCode;

import java.util.*;

//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
//注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
//示例 1：
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
//示例 2：
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
public class _0139_WordSplitting {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(Method(s,list));

    }
    public static boolean Method(String s,List<String> list){
        HashSet<String> set = new HashSet<>(list);
        boolean []f = new boolean[s.length()+1];
        f[0] = true;//开头预备
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
//           如果字符串 s 的前 j 个字符可以被分割（即 f[j] 为 true），
//           并且从 j 到 i 的子字符串（即 s.substring(j,i)）也在给定的单词列表中（即 set 中存在），
//           那么可以确认字符串 s 的前 i 个字符可以被成功分割成一个或多个在 list 中的单词。
                if(f[i-1] && set.contains(s.substring(j,i))){
                    f[i] = true;
                    break;
                }
            }
        }
        return f[s.length()];
    }
}
