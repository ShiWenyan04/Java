package LeetCode;
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
//假设环境不允许存储 64 位整数（有符号或无符号）。
//示例 1：
//输入：x = 123
//输出：321

//示例 2：
//输入：x = -123
//输出：-321

//示例 3：
//输入：x = 120
//输出：21

//示例 4：
//输入：x = 0
//输出：0
import java.util.ArrayList;
import java.util.Collections;


public class _07_IntegerInversion {
    public static void main(String[] args) {
        int x = -2147483648;
        System.out.println(Method(x));
    }
    public static int Method(int x) {
        String str = String.valueOf(x);//改成String
        int len = str.length();
        int result ;
        ArrayList<String> list = new ArrayList<>();
        if (str.charAt(0) == '-') {//有“-”时
            for (int i = 1; i < len; i++) {//存放元素到list中,并去除符号
                list.add(str.substring(i,i+1));
            }
            Collections.reverse(list);//逆序
            Method2(list).add(0, "-");//    去“0”，加符号
            result = Method3(list);//转int型
        } else {//无“-”时
            for (int i = 0; i < len; i++) {//存放元素到list中
                list.add(str.substring(i,i+1));
            }
            Collections.reverse(list);//逆序
            Method2(list);//    去“0”，加符号
            result = Method3(list);//转int型
        }
        return result ;
    }
//    去除0
    public static ArrayList<String> Method2(ArrayList<String> list){
        int len = list.size();
        if (len != 1){
            for (int i = 0; i < len; i++) {
                if (list.get(i) .equals("0")  ){//开头首个数字为0时
                    list.remove(i);//删除0
                    len--;//list长度减一个单位
                    i = 0;//索引回到第一个
                }
                if (!list.get(i) .equals( "0")){//不等于0时立马退出循环
                    break;
                }
            }
        }
        return list;
    }
//    转int
    public  static int Method3(ArrayList<String> list) {
        //str = StringUtils.join(list," ").replace(" ","");不知道为啥用不了
        String str;
        str = String.join(" ", list).replace(" ","");//转成字符串，并去掉空格
        if (Long.parseLong(str) <= 2147483647 &&Long.parseLong(str) >= -2147483647){
            return Integer.parseInt(str);//字符串改成int
        }
        return 0;
    }
}
