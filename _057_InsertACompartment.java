package LeetCode;

import java.util.ArrayList;
import java.util.List;

//给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
//在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
//返回插入之后的 intervals。
// 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
//示例 1：
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
public class _057_InsertACompartment {
    public static void main(String[] args) {
        int [][]intervals = {{1,3},{6,9}};
        int [] newInterval = {2,5};
        System.out.println(Method(intervals,newInterval));
    }
    public static int[][] Method(int[][]intervals,int [] newinterval){
        int i = 0;
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
//  //左侧区间
        while (i < n && intervals[i][1]<newinterval[0]){
            list.add(intervals[i]);
            i++;
        }
// //区间重叠 开始节点 一定小于等于newInterval的结束值 结束结点一定大于等于newInterval的开始值
        while(i<n&& intervals[i][1] >= newinterval[0]  && intervals[i][0] <= newinterval[1]){
            newinterval[0] = Math.min(intervals[i][0], newinterval[0]);
            newinterval[1] = Math.max(intervals[i][1],newinterval[1]);
            i++;
        }
        list.add(newinterval);
//    //右侧区间
        while(i < n){
            list.add(intervals[i]);
            i++;
        }
//返回数组形式
        return list.toArray(new int[list.size()][]);
    }
}
