package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

//给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。返回 需要移除区间的最小数量，使剩余区间互不重叠 。
//注意 只在一点上接触的区间是 不重叠的。例如 [1, 2] 和 [2, 3] 是不重叠的。
//示例 1:
//输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
//输出: 1
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
//示例 2:
//输入: intervals = [ [1,2], [1,2], [1,2] ]
//输出: 2
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
//示例 3:
//输入: intervals = [ [1,2], [2,3] ]
//输出: 0
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
public class _0435_NoOverlap {
    public static void main(String[] args) {
        int [][]intervals = {{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}};
        System.out.println(Method(intervals));
    }
    public static int Method(int [][] nums){
        Arrays.sort(nums, new Comparator<int[]>() {//
            @Override
            public int compare(int[] a, int[] b) {
                return a[1]-b[1];//比较第二维的,使数组的第二个数字呈现递增趋势，这样只需要配判断每一组数据的第一个数字是否在前一个区间里
            }
        });
        int len = 1;
        int start =0;
        for (int j = 1; j < nums.length; j++) {//可以类比参加活动，怎样才能跟多的参加活动呢，就是先参加最早结束的活动，留下更多的时间参加别的活动
            if(nums[start][1] <= nums[j][0]){//因为第二个数字永远升序，只需判断当前区间的第一个数字是否包含于前一个区间
                start = j;
                len ++;
            }
        }
        return nums.length-len;
    }
}
