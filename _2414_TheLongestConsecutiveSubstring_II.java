package LeetCode;
//字母序连续字符串 是由字母表中连续字母组成的字符串。换句话说，字符串 "abcdefghijklmnopqrstuvwxyz" 的任意子字符串都是 字母序连续字符串 。
//例如，"abc" 是一个字母序连续字符串，而 "acb" 和 "za" 不是。
//给你一个仅由小写英文字母组成的字符串 s ，返回其 最长 的 字母序连续子字符串 的长度。
//示例 1：
//输入：s = "abacaba"
//输出：2
//解释：共有 4 个不同的字母序连续子字符串 "a"、"b"、"c" 和 "ab" 。
//"ab" 是最长的字母序连续子字符串。
//示例 2：
//输入：s = "abcde"
//输出：5
//解释："abcde" 是最长的字母序连续子字符串。
public class _2414_TheLongestConsecutiveSubstring_II {
    public static void main(String[] args) {
        String s = "abcde" ;
        System.out.println(Method(s));
    }
    public static int Method(String s){
        int dp=1,ans = 0;
        int i=0;
        if (s.length() == 1){//长度为1直接返回
            return 1;
        }
        while(i<s.length()-1){//简单遍历，判断是否连续，连续dp+1，不连续dp=1；
            if ((int)s.charAt(i) == (int)s.charAt(i+1)-1){
                dp++;
            }else {
                dp = 1;
            }
            ans = Math.max(ans,dp);//比较每次连续的最大值
            i++;
        }
        return ans;
    }
}
