package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//在研究 DNA 时，识别 DNA 中的重复序列非常有用。
//给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
//示例 1：
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
//示例 2：
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
public class _0187_DuplicateDNASequences {
    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        System.out.println(Method(s));
    }
    public static List<String> Method(String s){
        HashSet<String> hashSet = new HashSet<>();
        List<String> list =new ArrayList<>();
        if (s.length() == 10){//10个为一组
             return list;
        }
        for (int i = 0; i <= s.length()-10; i++) {//十个依次遍历，若有重复并且从未保存在答案里的，就存到答案里
            //从未重复或者有重复并且已经保存过的，就只需要存入哈希表就行
            if(hashSet.contains(s.substring(i,i+10)) && !list.contains(s.substring(i,i+10))){
                list.add(s.substring(i,i+10));
            }else hashSet.add(s.substring(i,i+10));//从未重复或者有重复并且已经保存过的，就只需要存入哈希表就行
        }
        return list;
    }
}
