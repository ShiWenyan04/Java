package LeetCode;
//给定字符串列表 strs ，返回其中 最长的特殊序列 的长度。如果最长特殊序列不存在，返回 -1 。
//特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
// s 的 子序列可以通过删去字符串 s 中的某些字符实现。
//例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
//示例 1：
//输入: strs = ["aba","cdc","eae"]
//输出: 3
//示例 2:
//输入: strs = ["aaa","aaa","aa"]
//输出: -1
public class _0522_LongestSpecialSequence_II {
    public static void main(String[] args) {
        String [] str = {"aabbcc", "aabbcc","cb"};
        System.out.println(Method(str));
    }
    public static int Method(String [] str){
        boolean judge = false;
        int len = -1;
        for (int i = 0; i < str.length; i++) {//从低一个字符开始遍历判断
            judge = true;
            for (int j = 0; j < str.length; j++) {
                if (i!=j && isSubseq(str[i],str[j])){//判断j字符串是否为i字符串的子序列
                    judge = false;//如果是子序列，jude = false
                    break;
                }
            }
            if (judge){//不是子序列，就得出该字符的长度
                len = Math.max(len,str[i].length());
            }
        }
        return len;
    }
    public static boolean isSubseq(String s1,String s2){//判断s1中是否包含s2
        int i=0,j=0;
        while (i < s1.length()&&j<s2.length()){
            if (s1.charAt(i) == s2.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s1.length();
    }
}
