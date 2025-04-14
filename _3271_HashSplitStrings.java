package LeetCode;

//示例 1：
//输入：s = "abcd", k = 2
//输出："bf"
//解释：
//第一个字符串为 "ab" ，0 + 1 = 1 ，1 % 26 = 1 ，result[0] = 'b' 。
//第二个字符串为： "cd" ，2 + 3 = 5 ，5 % 26 = 5 ，result[1] = 'f' 。
//示例 2：
//输入：s = "mxz", k = 3
//输出："i"
//解释：
//唯一的子字符串为 "mxz" ，12 + 23 + 25 = 60 ，60 % 26 = 8 ，result[0] = 'i' 。
public class _3271_HashSplitStrings {
    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;
        System.out.println();
    }

    public static String Method(String s,int k) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i+=k) {
            int sum = 0;
            for (int j = 0; j < i+k; j++) {
                sum += s.charAt(j)-'a';//判断当前字母处于整个字母表的第几个，即为字母序列，然后在累加字母序列
            }
            result.append((char)sum%26+'a');//所得的序列总和%26，得到新的字母序列，再加上a即为ascal码表中的字母
        }
        return result.toString();
    }
}
