package LeetCode;
//给你一个包含若干星号 * 的字符串 s 。在一步操作中，你可以：
//选中 s 中的一个星号。
//移除星号 左侧 最近的那个 非星号 字符，并移除该星号自身。
//返回移除 所有 星号之后的字符串。
//示例 1：
//输入：s = "leet**cod*e"
//输出："lecoe"
//解释：从左到右执行移除操作：
//- 距离第 1 个星号最近的字符是 "leet**cod*e" 中的 't' ，s 变为 "lee*cod*e" 。
//- 距离第 2 个星号最近的字符是 "lee*cod*e" 中的 'e' ，s 变为 "lecod*e" 。
//- 距离第 3 个星号最近的字符是 "lecod*e" 中的 'd' ，s 变为 "lecoe" 。
//不存在其他星号，返回 "lecoe" 。
//示例 2：
//输入：s = "erase*****"
//输出：""
//解释：整个字符串都会被移除，所以返回空字符串。
public class _2390_RemovesTheAsteriskFromTheString {
    public static void main(String[] args) {
        String s = "erase*****";
        System.out.println(Method(s));
    }
    public static String Method(String s){
        int i =0;
        StringBuilder ans = new StringBuilder();
        while(i < s.length()){//遍历
            if (s.charAt(i) == '*'){//为“*”就只留下长度ans.length()-1的字符，即去除最后一个字符
              ans.setLength(ans.length()-1);
            }else {//存入ans
                ans.append(s.charAt(i));
            }
            i++;
        }
        return ans.toString();
    }
}
