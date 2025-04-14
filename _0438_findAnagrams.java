package LeetCode;

import java.util.*;

public class _0438_findAnagrams {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(Method(s,p));
    }
    public static List<Integer> Method(String s,String p){
        int m = s.length(), n = p.length();
        List<Integer> list = new ArrayList<>();
        if(m<n){
            return list;
        }
//        统计两个字符串的字符出现先次数，在同一长度下，如果每个字符出现的次数相同，则说明是异位符
        int [] sCount = new int[26];
        int [] pCount = new int[26];
//        先统计前pLen长度的字符,两个字符串的字符出现的次数
        for (int i = 0; i < n; i++) {
           sCount[s.charAt(i)-'a']++;
           pCount[p.charAt(i)-'a']++;
        }
//        如果在同一长度下，两个数组所有的值都相等，是异位符,字符串起始位置为0
        if(Arrays.equals(sCount,pCount)) list.add(0);
//        剩下的一部分继续统计字母数量；使用滑动窗口，每滑动一位，就删除已经出窗口的字符，添加新进窗口的字符
        for (int i = 0; i < m-n; i++) {
            sCount[s.charAt(i)-'a']--;
            sCount[s.charAt(i+n)-'a']++;
            if(Arrays.equals(sCount,pCount)) list.add(i+1);
        }
        return list;
    }
}
