package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

//给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为 更加简洁的规范路径。
//在 Unix 风格的文件系统中规则如下：
//一个点 '.' 表示当前目录本身。
//此外，两个点 '..' 表示将目录切换到上一级（指向父目录）。
//任意多个连续的斜杠（即，'//' 或 '///'）都被视为单个斜杠 '/'。
//任何其他格式的点（例如，'...' 或 '....'）均被视为有效的文件/目录名称。
//返回的 简化路径 必须遵循下述格式：
//始终以斜杠 '/' 开头。
//两个目录名之间必须只有一个斜杠 '/' 。
//最后一个目录名（如果存在）不能 以 '/' 结尾。
//此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
//返回简化后得到的 规范路径 。
//示例 1：
//输入：path = "/home/"
//输出："/home"
//解释：
//应删除尾随斜杠。
public class _071_SimplifyThePath {
    public static void main(String[] args) {
        String path= "/home/";
        System.out.println(Method(path));
    }
    public static String Method(String path){
        // 按照"/"分割路径
        String [] str = path.split("/");
        // 使用Deque来模拟栈的操作
        Deque<String> deque = new ArrayDeque<>();
        for (String string : str) {
            // 如果是".."，并且栈不为空，弹出栈顶元素
            if(string .equals("..")){
                if(!deque.isEmpty()){
                    deque.pop();
                }
            } else if (!string.isEmpty() && !string.equals(".")) {
                // 如果是有效目录（非空且非"."），加入栈
                deque.push(string);
            }
        }
        StringBuffer sb = new StringBuffer();
        if(deque.isEmpty()){
            // 如果栈为空，说明是根目录
            sb.append("/");
        }else {
            while(!deque.isEmpty()){
                // 如果栈不为空，将各部分拼接起来
                sb.append("/").append(deque.pollLast());
            }
        }
        return sb.toString();
    }
}
