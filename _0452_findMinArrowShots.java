package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0452_findMinArrowShots {
    public static void main(String[] args) {
        int [][]points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        System.out.println(Method(points));
    }
    public static int Method(int [][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));//按照结束位置排序
        int pose = points[0][1];
        int ans = 1;
        for (int[] point : points) {
            if(point[0] > pose){
                pose = point[1];
                ans++;
            }
        }
        return ans;
    }
}
