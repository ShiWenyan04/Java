package LeetCode;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

//示例 1：
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

//示例 2：
//输入：digits = ""
//输出：[]

import java.util.ArrayList;

//示例 3：
//输入：digits = "2"
//输出：["a","b","c"]
public class _017_Monograms {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(Method1(digits));
    }
    public static ArrayList<String> Method1(String digits){
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int len = digits.length(),index=0;
        if ( len == 0 ){
            return list;
        }
        Method(digits,list,sb,index);//用递归
        return list;
    }
    public static void Method (String digits , ArrayList<String> list , StringBuilder sb , int index){
        String []alphabet = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int len = digits.length();
        if (sb.length() == len){
                list.add(sb.toString());
                return;
            }
        Integer num = Integer.valueOf(String.valueOf(digits.charAt(index)));//按键的数字对应着字母表的索引
        for (int i = 0; i < alphabet[num].length(); i++) {
//第一次循环，进入的是第一个按键所对应的字母组，且保存第一个字母组合的第一个字母，而后的递归再次进入for，进行的是第二个按键的字母组，且开始保存第二个字母组合的第一个字母，若构成两个（按键的个数），立马退出当前第二个字母组合所对应的字母循环，然后开始下一个第二个字母组合当中的字母
            sb.append(alphabet[num].charAt(i));//按键所对应的字母拼接，sb.append用于将char参数的字符串表示形式附加到给定序列
            Method(digits,list,sb,index+1);//递归保存第二个字母组合当中的字母
            sb.deleteCharAt(index);//删除sb当中第二个字母，以便进入第一个字母组合的循环，开始第一个字母组合的下一个字母
        }

    }
}
