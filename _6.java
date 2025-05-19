package LanQiao_2024_Guo;

import java.util.Scanner;

public class _6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        StringBuilder sb = new StringBuilder();
        int cursor = 0;

        while (t-- > 0) {
            String s = in.nextLine().trim();

            if (s.matches("^insert \".*\"$")) {
                // 提取引号内的内容
                String content = s.substring(s.indexOf('"') + 1, s.lastIndexOf('"'));
                sb.insert(cursor, content);//在光标在的位置插入
                cursor += content.length();//光标更新位置
            } else if (s.matches("^\\d+h$")) {
                // 向左移动光标
                int move = Integer.parseInt(s.substring(0, s.length() - 1));//提取移动距离
                cursor = Math.max(0, cursor - move);//如果移动的距离大于光标左边的字符个数，光标为0，否则移动最小位置为光标位置-移动距离
            } else if (s.matches("^\\d+l$")) {
                // 向右移动光标
                int move = Integer.parseInt(s.substring(0, s.length() - 1));//提取移动距离
                cursor = Math.min(sb.length(), cursor + move);//如果光标右边的字符个数小于距离，光标为字符串长度，否则移动到光标位置+移动距离
            } else if (s.matches("^d\\d+h$")) {
                // 删除左侧指定长度的内容
                int deleteLength = Integer.parseInt(s.substring(1, s.length() - 1));//删除个数
                int deleteStart = Math.max(0, cursor - deleteLength);//要删除的起点，如果左边字符个数小于删除个数，那么直接清零，即开始位置为0
                //如果左边的字符个数大于删除个数，那么就应该为光标位置-删除个数
                sb.delete(deleteStart, cursor);//字符串删除
                cursor = deleteStart;//光标更新到最开始清除的位置
            } else if (s.matches("^d\\d+l$")) {
                // 删除右侧指定长度的内容
                int deleteLength = Integer.parseInt(s.substring(1, s.length() - 1));//删除个数
                int deleteEnd = Math.min(sb.length(), cursor + deleteLength);//删除的结尾，如果右边个数小于删除个数，清零，
                //如果右边个数大于删除个数，只需要光标+删除个数
                sb.delete(cursor, deleteEnd);//删除字符，光标不用动
            }
        }
        System.out.println(sb);
    }
}