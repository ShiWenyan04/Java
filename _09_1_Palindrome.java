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
public class _09_1_Palindrome {
    public static void main(String[] args) {
        int number1 = 121 ;
        String str1 = Method1(number1);
        String []strs1 = Method2(str1);
        Method3(strs1);
    }
//    形成字符串
    public static String Method1(int number){
        String str = String.valueOf(number);//int 转 字符串
        return str;
    }

//    放入数组
    public static String[] Method2(String str) {
        String []strs = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {//字符串切割存入数组
            strs[i] = str.substring(i, i + 1);
        }
        return strs;
    }
//    遍历判断
    public static void Method3(String[] strs){
        boolean judge = strs.length == 1;
        for (int i = 0; i <(strs.length)/2 ; i++) {
            if (strs[i].equals(strs[strs.length-i-1]) ) {
                judge = true;

            }else {
                judge = false;
                break;
            }
        }
        System.out.println(judge);
    }
}
