package LeetCode;
//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//例如，121 是回文，而 123 不是。

//输入：x = 121
//输出：true
//
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
public class _09_2_Palindrome {
    public static void main(String[] args) {
        int number = 1221 ;
        String str = Method1(number);
        Method2(str);
    }
    //    形成字符串
    public static String Method1(int number){
        String str = String.valueOf(number);//int 转 字符串
        return str;
    }
    //    遍历判断
    public static void Method2(String str){
        boolean judge = str.length() == 1;
            if (str.length()%2 == 0 ) {//字符串长度为偶数时
                if (str.substring( 0 ,( str.length()/2) ) .equals( Method3(str.substring( str.length()/2 , str.length())))){
                    judge = true;
                }
            }else {//字符串为奇数
                if (str.substring( 0 , str.length()/2 ).equals( Method3(str.substring( (str.length()/2)+1 , str.length()))))
                judge = true;
            }
        System.out.println(judge);
    }
    public static String Method3(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
