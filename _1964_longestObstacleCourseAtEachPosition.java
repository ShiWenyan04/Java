package LeetCode;

import java.util.Arrays;

public class _1964_longestObstacleCourseAtEachPosition {
    public static void main(String[] args) {
        int[] ob = {2, 2, 1};
        System.out.println(Arrays.toString(Method(ob)));
    }

    public static int[] Method(int[] obstacles) {
        int n = obstacles.length;
        //tails表示长度为i(取0-n-1)的递增子序列的末尾元素的最小值
        int[] f = new int[n];
        int[] ans = new int[n];
        int piles = 0;
        for (int i = 0; i < n; i++) {
            int num = obstacles[i];
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (f[mid] <= num) left = mid + 1; //这里不是严格递增，用<=即可，即1，4，5遇见5也是可以更新len的
                else right = mid; //此处找到的j或者i是tails中元素等于num的左侧边界,左边的都要小于num，所以更新tails[i] = num
            }
            f[left] = num;
            if (piles == right) piles++; //res==j表示tails[m] < num始终成立，那么num可以接在之后变成更长的子序列，len++
            ans[i] = left + 1; //这里第k个数是num，因为最后i=j，且0-j的数都是小于等于num的，再加上num本身即i+1
        }
        return ans;
    }

}
