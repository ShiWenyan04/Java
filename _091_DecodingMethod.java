package LeetCode;
//一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
//"1" -> 'A'
//"2" -> 'B'
//...
//"25" -> 'Y'
//"26" -> 'Z'
//示例 1：
//输入：s = "12"
//输出：2
//解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
//示例 2：
//输入：s = "226"
//输出：3
//解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
public class _091_DecodingMethod {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(Method(s));
    }
    public static int Method(String s){//运用动态规划，类似于青蛙跳台
        int n = s.length();
        int []f = new int[n+1];
        f[0] = 1;
        int i = 1;
        while (i <= n){
            if(s.charAt(i-1) != '0'){//只要在合理范围内，那么他独自就可以成为一个编码，此时相当于在前面每种可能的情况下多加一个数据
                f[i] += f[i-1];
            }
            if( i>1 && s.charAt(i-2) != '0'&& (s.charAt(i-1)-'0')+(s.charAt(i-2)-'0')*10 <= 26 ){
                //倘若该数字与前一个数字组成的两位数在合理范围内，那么就相当于在i-1之前的每种可能后面多加了一个两位数的编码
                f[i] += f[i-2];
            }
            i++;
        }
        return f[n];
    }
}
