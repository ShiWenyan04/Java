package LeetCode;
//给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
//注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
//示例 1：
//输入：a = "abcd", b = "cdabcdab"
//输出：3
//解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
//示例 2：
//输入：a = "a", b = "aa"
//输出：2
//示例 3：
//输入：a = "a", b = "a"
//输出：1
//示例 4：
//输入：a = "abc", b = "wxyz"
//输出：-1
public class _0686_RepeatOverlayStringMatching {
    public static void main(String[] args) {
        String a = "aaaaaaaaaaaaaaaaaaaaaab", b = "ba";
        System.out.println(Method(a,b));
    }
    public static int Method(String a,String b){
       StringBuilder sb = new StringBuilder();
       int ans = 0;
        // 拼接 'a' 直到 sb 长度至少等于 b 的长度
       while(sb.length()<b.length()){
           sb.append(a);
           ans++;
       }
       // 再追加一次 'a' 确保字符串长度足够
        sb.append(a);
        // 查找 b 在 sb 中的位置
       int index = sb.indexOf(b);
        if (index == -1) return -1;
       return index+b.length() > ans * a.length() ? ans+1:ans;
    }
}
