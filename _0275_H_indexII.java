package LeetCode;

//给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
//h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）至少 有 h 篇论文分别被引用了至少 h 次。
//请你设计并实现对数时间复杂度的算法解决此问题。
//示例 1：
//输入：citations = [0,1,3,5,6]
//输出：3
//解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
//     由于研究者有3篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3 。
//示例 2：
//输入：citations = [0,1,3,5,6]
//输出：2
public class _0275_H_indexII {
    public static void main(String[] args) {
        int [] citations = {1,1};
        System.out.println(Method(citations));
    }
    public static int Method(int[] citations){
        int left = 0;
        int right = citations.length-1;
        int mid = 0;
        if (citations.length == 1 && citations[0] != 0){
            return 1;
        }
        if (citations.length == 1 && citations[0] == 0){
            return 0;
        }
        int ans = 0;
        while(left <= right){//二分
            mid = (left + right)/2;
            if (citations[mid] >= citations.length-mid){//此时个数小于最高指数
                ans = citations.length-mid;//ans就为符合要求的论文个数
                right = mid-1;//需得让指数变小，个数变多，界限向右缩进
            }
            if (citations[mid] < citations.length-mid){//此时个数大于最高指数
                left = mid+1;//需得让指数变大，个数变小，界限向左缩进
            }
        }
        return ans;
    }
}
