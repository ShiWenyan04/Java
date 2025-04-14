package LeetCode;
//示例 1：
//输入：nums = [1,3,4,8], queries = [[0,1],[1,2],[2,3],[0,3]]
//输出：[2,1,4,1]
//解释：查询结果如下：
//- queries[0] = [0,1]：子数组是 [1,3] ，差绝对值的最小值为 |1-3| = 2 。
//- queries[1] = [1,2]：子数组是 [3,4] ，差绝对值的最小值为 |3-4| = 1 。
//- queries[2] = [2,3]：子数组是 [4,8] ，差绝对值的最小值为 |4-8| = 4 。
//- queries[3] = [0,3]：子数组是 [1,3,4,8] ，差的绝对值的最小值为 |3-4| = 1 。
//示例 2：
//输入：nums = [4,5,2,2,7,10], queries = [[2,3],[0,2],[0,5],[3,5]]
//输出：[-1,1,1,3]
//解释：查询结果如下：
//- queries[0] = [2,3]：子数组是 [2,2] ，差绝对值的最小值为 -1 ，因为所有元素相等。
//- queries[1] = [0,2]：子数组是 [4,5,2] ，差绝对值的最小值为 |4-5| = 1 。
//- queries[2] = [0,5]：子数组是 [4,5,2,2,7,10] ，差绝对值的最小值为 |4-5| = 1 。
//- queries[3] = [3,5]：子数组是 [2,7,10] ，差绝对值的最小值为 |7-10| = 3 。
public class _1906_AbsoluteMinimumValue_$$ {
    public static void main(String[] args) {
        int [] nums = {4,5,2,2,7,10};
        int [][]queries = {{2,3}, {0, 1}, {3, 4}, {0, 1},{1,2}};
        System.out.println(Method(nums,queries));
    }
    public static int [] Method (int[] nums, int[][] queries){
        int []ans = new int[queries.length ];
        int len = queries[0].length;
        for (int i=0;i<queries.length;i++){//遍历queries的每一组
            int min = Integer.MAX_VALUE;
            for (int j=queries[i][0];j<queries[i][len-1];j++){//以此组的值为界限，求的范围内最小的差绝对值，做减数
                if ((j == queries[i][len-1]-1 || j == queries[i][len-1]+1) && (min == 0||min == Integer.MAX_VALUE)){
                    if (Math.abs(nums[j]-nums[queries[i][len-1]]) == 0 ){
                        min = -1;
                        break;
                    }
                }
                for(int k=queries[i][0];k<=queries[i][len-1];k++){//做被减数
                    if (j!=k){//两个索引不相等，才能有效
                        if (Math.min(Math.abs (nums [j]-nums [k]),min)!= 0){
                            min = Math.min(Math.abs (nums [j]-nums [k]),min);
                        }
                    }
                }
            }
            ans [i] = min;
        }
        return ans;
    }
}
