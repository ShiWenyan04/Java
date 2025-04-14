package LeetCode;
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//求在该柱状图中，能够勾勒出来的矩形的最大面积。
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10

//输入： heights = [2,4]
//输出： 4
public class _084_MaximumRectangularArea {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        int area = 0, n = heights.length;
            // 遍历每个柱子，以当前柱子的高度作为矩形的高 h，
            // 从当前柱子向左右遍历，找到矩形的宽度 w。
        for (int i = 0; i < n; i++) {
             int w = 1, h = heights[i], j = i; //i指当前柱子索引，把i赋给j，是为了能够向左向右遍历，让j成为左边或右边的柱子的索引
             while (--j >= 0 && heights[j] >= h) {//左边柱子存在并且高于当前柱子的话，可形成较大矩形，宽为符合柱子的个数，高为当前柱子的高度
                 w++;
             }
             j = i;//让j的索引回到当前柱子，然后判断右边的柱子
             while (++j < n && heights[j] >= h) {//右边柱子存在并且高于当前柱子的话，可形成较大矩形，宽为符合柱子的个数，高为当前柱子的高度
                 w++;
             }
             area = Math.max(area, w * h);//w*h是以当前柱子为中心，所获得的最大矩形面积，然后与之前最大矩形面积比较
            }
        System.out.println(area);
    }
}

