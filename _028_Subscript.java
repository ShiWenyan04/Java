package LeetCode;
//给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。

//示例 1：
//输入：haystack = "sadbutsad", needle = "sad"
//输出：0
//解释："sad" 在下标 0 和 6 处匹配。
//第一个匹配项的下标是 0 ，所以返回 0 。

//示例 2：
//输入：haystack = "leetcode", needle = "leeto"
//输出：-1
//解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1
public class _028_Subscript {
    public static void main(String[] args) {
        String haystack = "aa";
        String needle = "aaaa";
        System.out.println(Method(haystack,needle));
    }
    public static int Method(String haystack,String needle){
        int k = needle.length() ;
        int n = haystack.length();
        if (haystack.length() < needle.length()){//haystack字符串必须大于needle
            return -1;
        }
        for (int i = 0; i < n ; i++,k++) {
            if (haystack.substring(i,k).equals(needle)){//从头开始，截取与needle相同长度的字符串与之比较
                return i ;
            }
            if (i == (haystack.length() - needle.length()) && !haystack.substring(i,k).equals(needle)){//当索引值往后的个数不足以凑成needle字符串，并且不相等时，打断循环
                break;
            }

        }
        return -1;
    }
}
