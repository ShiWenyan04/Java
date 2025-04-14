package LeetCode;
//给你两个字符串 coordinate1 和 coordinate2，代表 8 x 8 国际象棋棋盘上的两个方格的坐标。
//以下是棋盘的参考图。
//如果这两个方格颜色相同，返回 true，否则返回 false。
//坐标总是表示有效的棋盘方格。坐标的格式总是先字母（表示列），再数字（表示行）。
//示例 1：
//输入： coordinate1 = "a1", coordinate2 = "c3"
//输出： true
//解释：
//两个方格均为黑色。
//示例 2：
//输入： coordinate1 = "a1", coordinate2 = "h3"
//输出： false
//解释：
//方格 "a1" 是黑色，而 "h3" 是白色。
public class _3274_WhetherTheColorsAreTheSame {
    public static void main(String[] args) {
        String coordinate1 = "d1", coordinate2 = "h4";
        System.out.println(Method(coordinate1,coordinate2));
    }
    public static boolean Method(String coordinate1 ,String coordinate2 ){
        int a = (coordinate1.charAt(0) + coordinate1.charAt(1))%2;//考虑奇偶性
        int b = (coordinate2.charAt(0) + coordinate2.charAt(1))%2;
        return a==b;
    }
}
