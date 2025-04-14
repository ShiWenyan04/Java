package LeetCode;
//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
//单词 是指仅由字母组成、不包含任何空格字符的最大子字符串

//示例 1：
//输入：s = "Hello World"s = "Hello World"
//输出：5
//解释：最后一个单词是“World”，长度为 5。

//示例 2：
//输入：s = "   fly me   to   the moon  "
//输出：4
//解释：最后一个单词是“moon”，长度为 4。

import java.util.ArrayList;
import java.util.Collections;

//示例 3：
//输入：s = "luffy is still joyboy"
//输出：6
//解释：最后一个单词是长度为 6 的“joyboy”。
public class _058_1_TheLengthOfTheLastWord {
    public static void main(String[] args) {
        String s = "luffy is still joyboy";
        String [] strs = Method1(s);//字符串改字符串数组
        String str = Method2(strs);
        System.out.println(str + str.length());
    }
//    字符串改字符串数组
    public static String[] Method1(String str) {
        String []strs = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {//字符串切割存入数组
            strs[i] = str.substring(i, i + 1);
        }
        return strs;
    }
//    逆序截取最后一个单词
    public static String Method2(String [] str){
        ArrayList list = new ArrayList<>();
        int a = 0;
            for (int i = str.length; i > 0; i--) {//标记末尾非空格位置
                if (!str [i-1].equals(" ")) {
                    a = i;//非空格的索引
                    break;
                }
            }
            for (int j = a; j > 0; j--) {//从非空格位置开始遍历，直到遇到空格
                if (str [j-1].equals(" ")) {
                    break;
                }
                list.add(str[j-1]);
            }
        Collections.reverse(list);//逆序
        return Method3(list);//调用方法转换成字符串并返回
    }
//    链表内的内容转换成字符串形式
    public static String Method3 (ArrayList list) {
        StringBuilder sb = new StringBuilder();
        for (Object s : list) {//循环将a中的值存入sb中
            sb.append(s);
        }
        return sb.toString();//转成String，并返回
    }
}
