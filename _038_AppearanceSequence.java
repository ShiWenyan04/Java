package LeetCode;
//「外观数列」是一个数位字符串序列，由递归公式定义：
//countAndSay(1) = "1"
//countAndSay(n) 是 countAndSay(n-1) 的行程长度编码。
//行程长度编码（RLE）是一种字符串压缩方法，其工作原理是通过将连续相同字符（重复两次或更多次）替换为字符重复次数（运行长度）和字符的串联。例如，要压缩字符串 "3322251" ，我们将 "33" 用 "23" 替换，将 "222" 用 "32" 替换，将 "5" 用 "15" 替换并将 "1" 用 "11" 替换。因此压缩后字符串变为 "23321511"。
//给定一个整数 n ，返回 外观数列 的第 n 个元素。
//示例 1：
//输入：n = 4
//输出："1211"
//解释：
//countAndSay(1) = "1"
//countAndSay(2) = "1" 的行程长度编码 = "11"
//countAndSay(3) = "11" 的行程长度编码 = "21"
//countAndSay(4) = "21" 的行程长度编码 = "1211"
//示例 2：
//输入：n = 1
//输出："1"
public class _038_AppearanceSequence {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(Method(n));
    }
    public static String Method(int n){
        if (n == 1){//当n为一时，形成编码默认为1
            return String.valueOf(n);
        }
        String s = "1";

        for (int i = 1; i < n; i++) {//次数
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < s.length(); j++) {//从首位开始判断行程长度编码
                int count = 1;//初始化数字个数为1
                while(j+1<s.length() && s.charAt(j) == s.charAt(j+1)){//确保下一个数字不超过界限，且当前数字是否与下一个数字相同，以此来决定行程长度编码
                    count++;
                    j++;
                }
                sb.append(count).append(s.charAt(j));//count为该数字个数，格式为：数字个数+数字
            }
            s = String.valueOf(sb);//化成字符串赋给s，再重新进行判断，但绝对不能超过次数n
        }
        return s;
    }
}
