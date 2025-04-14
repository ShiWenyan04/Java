package LeetCode;

//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
//示例 1：
//输入：nums = [1,2,3,1], k = 3
//输出：true
//示例 2：
//输入：nums = [1,0,1,1], k = 1
//输出：true
//示例 3：
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false
public class _0218_1_DuplicateElements_II {
    public static void main(String[] args) {
        int [] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(Method(nums,k));
    }
    public static boolean Method(int[] nums, int k){
        for (int i = 0; i < nums.length-1; i++){
            int j=i+1,l= nums.length-1;//j为从前往后递进的坐标，l为从后往前递进的坐标
            while((j<= nums.length-1 && j<=l) || (l > i && l >= j)){//规定界限
                if (nums[i] == nums[j] && Math.abs(j-i) <= k){//倘若前面坐标所对应的数字相同，且坐标值差小于等于k
                    return true;
                }else j++;
                if (nums[i] == nums[l] && Math.abs(l-i) <= k){//倘若后面坐标所对应的数字相同，且坐标值差小于等于k
                    return true;
                }else l--;
            }
        }
        return false;
    }
}
