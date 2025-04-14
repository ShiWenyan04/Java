package LeetCode;

import java.util.*;

//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
//示例 1:
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//示例 2:
//输入: strs = [""]
//输出: [[""]]
//示例 3:
//输入: strs = ["a"]
//输出: [["a"]]
//
public class _049_AlphabeticGrouping {
    public static void main(String[] args) {
        String []str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(Method1(str));
    }
    public static List<List<String>> Method1(String [] str){
        //定义一个哈希表，value值为List<String>类型，即可构成一个一维list，而后用新的list包含哈希表，即可得二维list
        HashMap<String,List<String>> hashMap = new HashMap<>();
        int n = str.length;
        for (int i = 0; i < str.length; i++) {
            char []ch = str[i].toCharArray();
            //排序，形成key（异位词的字母都相同，排序后都是同一个字符串）
            Arrays.sort(ch);
            String key = new String(ch);
            //getOrDefault，若是存在key所对应的value，则com为value，反之，com为新的一维list。
            List<String>com = hashMap.getOrDefault(key,new ArrayList<String>());
            //com更新list存放的值
            com.add(str[i]);
            //hashmap将更新后的com存入，如若是新的com，就新开一个map
            hashMap.put(key,com);
        }
        //新的list包含哈希表，即可得二维list
        return new ArrayList<List<String>>(hashMap.values());
    }
}
