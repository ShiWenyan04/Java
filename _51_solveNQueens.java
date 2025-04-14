package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _51_solveNQueens {
    static int n = 4;
    static int []arr = new int[n];// 存储每行皇后的位置
    public static void main(String[] arg) {
        List<List<String>> list = new ArrayList<List<String>>();
        Method(list,0,n);
//        for (List<String> l : list) {
//            for (String s : l) {
//                System.out.println(s);// 打印每个解
//            }
//        }
        System.out.println(list);
    }
    // 检查当前位置 (i, j) 是否可以放置皇后
    public static boolean place(int i,int j) {
        if(i==0)return true;
        for (int k = 0; k < i; k++) {
            // 检查列是否被占用，检查对角线是否有冲突
            if(arr[k] == j||Math.abs(arr[k]-j) == Math.abs(i-k)) {
                return false;
            }
        }
        return true;
    }
    //[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    public static void Method(List<List<String>> list,int i,int n) {
        if(i >= n) {// 找到一个解
            List<String> list2 = print(arr);
            list.add(list2);// 保存解,由于n皇后的位置每一种都是唯一的，所以不用盘算是否出现过同样的
            return ;
        }
        for (int j = 0; j < n; j++) {
            if(place(i, j)) {
                arr[i] = j; // 放置皇后
                Method(list,i+1,n);// 递归到下一行
                arr[i] = 0;// 回溯
            }
        }
    }
    // 根据皇后的位置数组生成棋盘的字符串表示
    public static List<String> print(int []arr){
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[]row = new char[n];
            Arrays.fill(row,'.');
            row[arr[i]] = 'Q';
            list.add(String.valueOf(row));
        }
        return list;
    }
}

