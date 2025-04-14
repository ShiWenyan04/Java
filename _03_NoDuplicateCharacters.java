package LeetCode;
//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
//示例 1:
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//示例 2:
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//示例 3:
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
public class _03_NoDuplicateCharacters {
    public static void main(String[] args) {
        String s ="a";
        System.out.println( Method(s, ""));;
    }
    public static int Method(String s, String str){
       String pre ;
       int left ,right ;
       if (s.length() == 1){//s长度为1
           return 1;
       }else if(s.isEmpty()){//s为空
           return 0;
       }
        for ( left = 0; left < s.length()-1; left++) {//从头遍历
            right = left+1;
            pre = s.substring(left,right);
            while(left < right && right < s.length()){//规定界限
                boolean judge = false;
                for (int i = 0; i < pre.length(); i++) {//判断已有字符串是否与现在字符有相同
                    if(pre.charAt(i) == s.charAt(right)){//判断已有字符串是否与现在字符有相同
                        judge = true;
                        break;
                    }
                    if (i == pre.length()-1){//到最后一个时，都没有相同元素，那就添加该字符
                        pre = s.substring(left,right+1);
                        break;
                    }
                }
                if (judge){//倘若有相同字符，开始下一轮字符串循环，截取新的无相同字符的字符串
                    break;
                }
                right++;
            }
            if (str.length() < pre.length()){//倘若pre长度大于str，赋值给str，保证str始终是最长无相同字符的字符串
                str = pre;
            }
        }
        return str.length();
    }
}
