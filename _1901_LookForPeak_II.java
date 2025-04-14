package LeetCode;

import ShiYan6_2.Method;

import java.util.ArrayList;
import java.util.List;

//一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
//给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置 [i,j] 。
//你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。
//要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
//示例 1:
//输入: mat = [[1,4],[3,2]]
//输出: [0,1]
//解释: 3 和 4 都是峰值，所以[1,0]和[0,1]都是可接受的答案。
//示例 2:
//输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
//输出: [1,1]
//解释: 30 和 32 都是峰值，所以[1,1]和[2,2]都是可接受的答案。
//
public class _1901_LookForPeak_II {
    public static void main(String[] args) {
        int[][] mat = {{47, 30, 35, 8, 25}, {6, 36, 19, 41, 40}, {24, 37, 13, 46, 5}, {3, 43, 15, 50, 19}, {6, 15, 7, 25, 18}};
        System.out.println(Method(mat));
    }

    public static int[] Method(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int up = 0, down = n-1, mid = 0;
        int max = -1;
        int index1 = 0;
        while (up <= down) {//从中间行列开始
            mid = (up + down) / 2;
            for (int i = 0; i < m; i++) {//寻找中间行最大值及坐标
                if (mat[mid][i] > max) {
                    max = mat[mid][i];
                    index1 = i;
                }
            }
            if (mid >= 1 &&mat[mid][index1] < mat[mid-1][index1]) {//倘若当前最大值小于上一行的值
                down = mid;
                continue;
            }else if(mid < n-1 &&mat[mid][index1] < mat[mid+1][index1]){//倘若当前最大值小于下一行的值
                up = mid+1;
                continue;
            }
            return new int[]{mid,index1};
        }
        return new int[]{0};
    }
}
