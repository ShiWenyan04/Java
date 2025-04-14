package LeetCode;
import java.util.HashSet;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
//示例 1：
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
//示例 2：
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
public class _0128_LongestContinuousSequence {
    public static void main(String[] args) {
        int[]nums={100,4,200,1,3,2};
        System.out.println(Method(nums));
    }
    public static int Method(int[] nums){
        if(nums.length == 0){
            return 0;
        }else if (nums.length ==1){
            return 1;
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums){//去除重复值，每个值存入hs
            hs.add(i);
        }
        int ans=1;//倘若没有连续的数列，那么最长的序列就是1
        int preAns;
        for (int m : hs) {//遍历hs中的值
            if (hs.contains(m-1)){//如果存在当前值-1，则说明，当前值并不是连续数列的首个元素
                continue;
            }else {//如果不存在当前值-1，则说明，当前值是连续数列的首个元素
                preAns = 1;//此时preAns开始计数
                while(hs.contains(m+1)){//如果存在当前值+1，preans+1，当前值递进到连续数列的下一个值
                    preAns+=1;
                    m+=1;
                }
            }
            ans = Math.max(ans,preAns);
        }
        return ans;
    }
}
