package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//示例 1：
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//示例 2：
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
public class _056_MergeIntervals {
    public static void main(String[] args) {
        int [][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Method(intervals));
    }
    public static int [][]Method(int[][]intervals){
        List<int[]> list = new ArrayList<>();
        int start ,end;
        if (intervals.length == 1){//长度为一，直接返回
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {//二维数组排序
            @Override
            public int compare(int[] intervals1, int[] intervals2) {
                return intervals1[0] - intervals2[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {//遍历，每一组的首位为start，末尾为end，上一组的end大于下一组的start，说明有重叠
            start = intervals[i][0];
            end = intervals[i][1];//首个区间直接存入list，其余的依次与list最后一个区间进行比较，没有重叠就存进list
            if (list.isEmpty() || list.get(list.size()-1)[1] < start){
                list.add(new int[]{start,end});
            }else {//【start1，end1】，【start2，end2】，前者为list中最后一个区间，倘若end1与start2有重叠，只需更新end1，end1=max{end1，end2}
                list.get(list.size()-1)[1] = Math.max(end,list.get(list.size()-1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);//list转为二维数组
    }
}
