package LeetCode;

import java.util.StringTokenizer;

//如果单词的长度为 1 或者 2 ，所有字母变成小写。
//否则，将单词首字母大写，剩余字母变成小写。
//示例 1：
//输入：title = "capiTalIze tHe titLe"
//输出："Capitalize The Title"
//示例 2：
//输入：title = "First leTTeR of EACH Word"
//输出："First Letter of Each Word"
//示例 3：
//输入：title = "i lOve leetcode"
//输出："i Love Leetcode"
public class _2129_CapitalizeTheFirstLetterOfTheTitle {
    public static void main(String[] args) {
        String title = "F";
        System.out.println(Method(title));
    }
    public static String Method(String title){
        StringTokenizer st = new StringTokenizer(title," ");//把单词分开
        StringBuilder sb = new StringBuilder();//构成新句子
        while(st.hasMoreTokens()){
            String preStr = st.nextToken();
            for (int k = 0; k < preStr.length(); k++) {
                char c =  preStr.charAt(k);
                if (preStr.length() > 2 && k == 0 ){//单词个数大于2时，首字母大写
                    c = Character.toUpperCase(c);
                }else {//其余小写
                    c = Character.toLowerCase(c);
                }
                sb.append(c);
            }
            sb.append(" ");//单词之间有空格
        }
        return sb.toString();
    }
}
