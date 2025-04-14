package LeetCode;

import java.util.ArrayList;
import java.util.List;

//给定一个三角形 triangle ，找出自顶向下的最小路径和。
//每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
//示例 1：
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
// 2
// 3 4
// 6 5 7
// 4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//示例 2：
//输入：triangle =[[-1],[2,3],[1,-1,-3]]
//输出：-1
public class _0120_TriangleMinimumPathSum {
    public static void main(String[] args) {
        int [][] triangle = {{2},{3,4}, {6,5,7},{4,1,8,3}};
        List<List<Integer>> tri = new ArrayList<>();
        List<Integer>  list1 = new ArrayList<>();
        for (int [] group: triangle){
            for (int num: group){
                list1.add(num);
            }
            tri.add(new ArrayList<>(list1));
            list1.removeAll(list1);
        }
        System.out.println(Method(tri));
    }
    public static int Method(List<List<Integer>> triangle){
        int []f = new int[triangle.size()];
        int i = 0;
        for (; i < triangle.size(); i++) {// 最后一行遍历
            f[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int k = triangle.size()-2; k >=0 ; k--) {//从上往下
            for (int l = 0; l <= k ; l++) {//每一行的元素，相邻两个最小的加上上一行的值
                f[l] = Math.min(f[l],f[l+1]) + triangle.get(k).get(l);
            }
        }
        return f[0];
    }
}
