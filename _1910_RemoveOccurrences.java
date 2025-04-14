package LeetCode;
//示例 1：
//输入：s = "daabcbaabcbc", part = "abc"
//输出："dab"
//解释：以下操作按顺序执行：
//- s = "daabcbaabcbc" ，删除下标从 2 开始的 "abc" ，得到 s = "dabaabcbc" 。
//- s = "dabaabcbc" ，删除下标从 4 开始的 "abc" ，得到 s = "dababc" 。
//- s = "dababc" ，删除下标从 3 开始的 "abc" ，得到 s = "dab" 。
//此时 s 中不再含有子字符串 "abc" 。
//示例 2：
//输入：s = "axxxxyyyyb", part = "xy"
//输出："ab"
//解释：以下操作按顺序执行：
//- s = "axxxxyyyyb" ，删除下标从 4 开始的 "xy" ，得到 s = "axxxyyyb" 。
//- s = "axxxyyyb" ，删除下标从 3 开始的 "xy" ，得到 s = "axxyyb" 。
//- s = "axxyyb" ，删除下标从 2 开始的 "xy" ，得到 s = "axyb" 。
//- s = "axyb" ，删除下标从 1 开始的 "xy" ，得到 s = "ab" 。
//此时 s 中不再含有子字符串 "xy" 。
public class _1910_RemoveOccurrences {
    public static void main(String[] args) {
        String s = "daabcbaabcbc", part = "abc";
        System.out.println(Method(s,part));
    }
    public static String Method(String s, String part){
        while(s.contains(part)) {
            for (int i = 0; i < s.length(); i++) {//
                if (part.equals(s.substring(i, i + part.length()))) {//三个为一组，查看是否与part相等
                    s = s.substring(0, i) + s.substring(i + part.length());//改组前一半+改组后一半，等于新s
                    break;//减去part后从头开始查找是否还有part存在s中
                }
            }
        }
        return s;
    }
}
