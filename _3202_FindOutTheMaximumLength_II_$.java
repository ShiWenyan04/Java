package LeetCode;
//给你一个整数数组 nums 和一个 正 整数 k 。nums 的一个子序列
// sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列 ：
//(sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k返回 nums 的 最长有效子序列 的长度。
//示例 1：
//输入：nums = [1,2,3,4,5], k = 2
//输出：5
//解释：最长有效子序列是 [1, 2, 3, 4, 5] 。
//示例 2：
//输入：nums = [1,4,2,3,1,4], k = 3
//输出：4
//解释：最长有效子序列是 [1, 4, 1, 4] 。
public class _3202_FindOutTheMaximumLength_II_$ {
    public static void main(String[] args) {
        int [] nums = {1,4,2,3,1,4};
        int k = 3;
        System.out.println(Method(nums,k));
    }
//(a+b)%k = (b+c)%k,移项得(a-c)%k = 0, 再移项得a%k = c%k
    public static int Method(int [] nums ,int k) {
        int [][] count = new int[2][k];
        int ans = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (count[0][nums[i]%k] != 0){
                count[0][nums[i]%k]+=1;
            }else {
                count[0][nums[i]%k] = nums[i]%k;
            }
            for (int j = i+2; j < nums.length; j+=2) {
                if (count[0][i] == nums[j]%k){
                    count[1][i] = count[0][i]+1;
                }
            }
        }
        for (int l : count[1]) {
            ans = Math.max(l,ans);
        }
        return ans+1;
    }
}
