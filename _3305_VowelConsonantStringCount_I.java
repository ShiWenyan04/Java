package LeetCode;

import java.util.HashSet;

//返回 word 的子字符串中，每个元音字母（'a'、'e'、'i'、'o'、'u'）至少 出现一次，并且 恰好 包含 k 个辅音字母的子字符串的总数。
//示例 1：
//输入：word = "aeioqq", k = 1
//输出：0
//示例 2：
//输入：word = "aeiou", k = 0
//输出：1
//解释：
//唯一一个包含所有元音字母且不含辅音字母的子字符串是 word[0..4]，即 "aeiou"。
//示例 3：
//输入：word = "ieaouqqieaouqq", k = 1
//输出：3
public class _3305_VowelConsonantStringCount_I {
    public static void main(String[] args) {
        String word = "aeiooq";
        int k = 1;
        int ans  = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            int countFu = 0;
            for (int l = i; l < word.length() && countFu <= k; l++) {
                if (isVowel(word.charAt(l))){//判断是否为aeiou中的一个
                    hashSet.add(word.charAt(l));//存哈希，重复值不存入
                }else {
                    countFu++;//为辅音，辅音个数加一
                }
                if (countFu == k && hashSet.size() == 5){//当元音个数为5，辅音个数为k时答案加一
                    ans ++;
                }
            }
            hashSet.clear();
        }
        System.out.println(ans);
    }
    public static boolean isVowel(char ch){//判断是否为aeiou中的一个
        return ch == 'a'||ch == 'e'||ch == 'i'||ch == 'o'||ch == 'u';
    }
}
