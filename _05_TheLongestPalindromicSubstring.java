package LeetCode;
//给你一个字符串 s，找到 s 中最长的回文子串。
//示例 1：
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//示例 2：
//输入：s = "cbbd"
//输出："bb"
public class _05_TheLongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "a";
        String str = "";
        int n = s.length();
        System.out.println(Method(s,str,n));
    }
    public static String Method(String s,String str,int n){
        String pre = "";
        String str1, str2;
        String strLen = "";
        if (s.length() == 1){//长度为一，直接返回s
            return s;
        }else if(s.isEmpty()){//长度为空
            return "";
        }
        for (int i = 0 ; i < n-1; i++) {//中心点遍历
            str1 = Method2(s,str,pre,n,i,i+1);//第一种情况：回文串为偶数串，中心点为两个
            str2 = Method2(s,str,pre,n,i-1,i+1);//第二种情况：回文串为奇数串，中心点为一个
            if(!str1.isEmpty() && str1.length() >= str2.length() && str1.length() >= strLen.length()){
                strLen =  str1;//比较第一种情况和第二种情况得到的字符串的长度，长的赋值给strlen
            }else if (!str2.isEmpty() && str1.length() <= str2.length() && str2.length() >= strLen.length()){
                strLen =  str2;
            }else if (str1.isEmpty() && str2.isEmpty() && strLen.isEmpty()) {
            strLen = s.substring(0,1);//倘若两个为空，strlen也为空，strlen默认为s的第一个字母
            }
        }
        return strLen;
    }
    //形成回文字符串
    public static String Method2(String s,String str, String pre,int n, int left, int right){
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)){//规定界限，左右两个字符相等
                pre = s.substring(left,right+1);//回文字符串
                left--;
                right++;
            }
            if (pre.length() == s.length()){//长度与s相等，直接返回
                return pre;
            }
        if (pre.length() > str.length()){
            str = pre;
        }
        return str;
    }
}
