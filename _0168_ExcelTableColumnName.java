package LeetCode;
//给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
//例如：
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28
//...
//示例 1：
//输入：columnNumber = 1
//输出："A"
//示例 2：
//输入：columnNumber = 28
//输出："AB"
//示例 3：
//输入：columnNumber = 701
//输出："ZY"
public class _0168_ExcelTableColumnName {
    public static void main(String[] args) {
        int columnNumber = 1;
        System.out.println(Method(columnNumber));
    }
    public static String Method(int columnNumber) {
        StringBuffer sb = new StringBuffer();
        while (columnNumber != 0) {
            columnNumber--;//首先将 columnNumber 减 1。这是因为英文字母表是从 A 开始的，而数组索引是从 0 开始的，所以需要减去 1 来对齐。
            sb.append((char) (columnNumber % 26 + 'A'));//计算 columnNumber 除以 26 的余数，这个余数代表当前字母在英文字母表中的位置减去 1（因为 'A' 是 1，不是 0）。
            columnNumber /= 26;//将 columnNumber 除以 26，准备处理下一个字母。
        }
        return sb.reverse().toString();//将 StringBuffer 对象 sb 中的字符序列反转，并转换为字符串返回。
        // 反转是因为字母是从低位到高位处理的，而我们希望最终的字符串是从高位到低位的。
    }
}
