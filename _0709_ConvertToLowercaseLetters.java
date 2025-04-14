package LeetCode;

//给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
//示例 1：
//输入：s = "Hello"
//输出："hello"
//示例 2：
//输入：s = "here"
//输出："here"
//示例 3：
//输入：s = "LOVELY"
//输出："lovely"
public class _0709_ConvertToLowercaseLetters {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(Method(s));
    }
    public static String Method(String s){
        int  i = 0 ;
        StringBuilder str = new StringBuilder();
        while(i<s.length()){
            char c = s.charAt(i);
            if (s.charAt(i) <= 90 && s.charAt(i) >= 65){//改小写
                c += 32;
            }
            str.append(c) ;
            i++;
        }
        return str.toString();
    }
}
