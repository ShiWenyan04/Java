package LeetCode;
//给你两个 版本号字符串 version1 和 version2 ，请你比较它们。版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略前导零。
//比较版本号时，请按 从左到右的顺序 依次比较它们的修订号。如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。
//返回规则如下：
//如果 version1 < version2 返回 -1，
//如果 version1 > version2 返回 1，
//其他情况返回0
//示例 1：
//输入：version1 = "1.2", version2 = "1.10"
//输出：-1
//解释version1 的第二个修订号为 "2"，version2 的第二个修订号为 "10"：2 < 10，所以 version1 < version2。
//示例 2：
//输入：version1 = "1.01", version2 = "1.001"
//输出：0
//解释：忽略前导零，"01" 和 "001" 都代表相同的整数 "1"。
//示例 3：
//输入：version1 = "1.0", version2 = "1.0.0.0"
//输出：0
//解释：version1 有更少的修订号，每个缺失的修订号按 "0" 处理。
public class _0165_CompareVersionNumber {
    public static void main(String[] args) {
        String version1 = "1.0";
        String version2 = "1.0.0.2";
        System.out.println(Method(version1,version2));
    }
    public static int Method(String version1,String version2) {
        int start1 = 0;
        int start2 = 0;
        int judge = 0;
        while (start1 < version1.length() || start2 < version2.length()) {//出现1.0和1.0.0.2这种情况，还要继续判断，需将后者的大于0的数字都找出来
            int num1 = 0, num2 = 0;//从‘.’开始分割成子字符串
            while (start1 < version1.length() && version1.charAt(start1) != '.') {//在遍历中要限定范围，倘若不为‘.’，就用乘10的方法累加，构成十进制的int型num
                num1 = Integer.valueOf(version1.charAt(start1++)) + num1 * 10 - '0';//-‘0’是为了从ascll码值的0开始记录数字
            }
            while (start2 < version2.length() && version2.charAt(start2) != '.') {//在遍历中要限定范围，倘若不为‘.’，就用乘10的方法累加，构成十进制的int型num
                num2 = Integer.valueOf(version2.charAt(start2++))+ num2 * 10 -'0';
            }
            if (num1 > num2) {//题目要求
                judge = 1;
                break;
            } else if (num1 < num2) {
                judge = -1;
                break;
            } else judge = 0;
            start1++;//迭代变量自加
            start2++;
        }
        return judge;
    }
}
