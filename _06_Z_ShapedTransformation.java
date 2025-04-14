package LeetCode;

//将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
//之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
//请你实现这个将字符串进行指定行数变换的函数：
//string convert(string s, int numRows);
//示例 1：
//输入：s = "PAYPALISHIRING", numRows = 3
//输出："PAHNAPLSIIGYIR"
//示例 2：
//输入：s = "PAYPALISHIRING", numRows = 4
//输出："PINALSIGYAHRPI"
//解释：
//P     I     N
//A   L S   I G
//Y A   H R
//P     I
public class _06_Z_ShapedTransformation {
    public static void main(String[] args) {
        String s = "PAYPAL";
        int numRows = 4;
        System.out.println(Method(s,numRows));
    }
    public static String Method(String s, int numRows){
        int times;
        if (numRows == 1){//行数为1，直接返回s
            return s;
        }else {//否则计算次数，即需要几个v字形对折
            if (s.length() % ( 2*numRows-2 ) == 0){//若能整除，次数为整除后的值
                times = s.length()/( 2*numRows-2 );
            }else times = 1+(s.length()/( 2*numRows-2 ));//不能整除即为，整出后的值加余数
        }
        String [][]str = new String[numRows][times * (2*numRows - 2)];//初始化一个二维数组
        for (int n = 0; n < times; n++) {//遍历次数
            int i = 0;//列、行的索引迭代变量
            int j = 0;//表示字符串的字符所对应的索引
            int start = (numRows -1)*2*n;//每一列的第一个数（字符串中已经排列的字符个数）
            int end = (numRows - 1)*(2*n+1);//每一列的最后一个数（字符串中已经排列的字符个数）
            while(true){//在二维数组中形成列
                if (j > end || j == s.length()){//j等于每一列最后一个数字（字符串中已经排列的字符个数）,开始斜着录入
                    i = 1;
                    break;
                }
                if (start <= j && j <= end){
                    str[i][n*(numRows-1)] = s.substring(j,j+1);
                }
                j++;
                i++;
            }
            while(true){//在二维数组中斜着排列
                if (j == s.length()){//字符串录完
                    break;
                }
                if ((numRows-1)-i >= 1){//斜着录入，数字的行索引会逐个增加，不能录入到每一列的首位
                    str[(numRows-1)-i][n*(numRows-1)+i] = s.substring(j,j+1);
                }else {
                    break;
                }
                i++;
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String []row : str){//将二位数组打印，若为空则不打印
            for (String el : row){
                if (el != null){
                    sb.append(el);
                }
            }
        }
        return sb.toString();
    }
}
