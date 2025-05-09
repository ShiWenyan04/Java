package LeetCode;
//现有一份 n + m 次投掷单个 六面 骰子的观测数据，骰子的每个面从 1 到 6 编号。观测数据中缺失了 n 份，你手上只拿到剩余 m 次投掷的数据。幸好你有之前计算过的这 n + m 次投掷数据的 平均值 。
//给你一个长度为 m 的整数数组 rolls ，其中 rolls[i] 是第 i 次观测的值。同时给你两个整数 mean 和 n 。
//返回一个长度为 n 的数组，包含所有缺失的观测数据，且满足这 n + m 次投掷的 平均值 是 mean 。如果不存在答案，返回一个空数组。k 个数字的 平均值 为这些数字求和后再除以 k 。
//如果存在多组符合要求的答案，只需要返回其中任意一组即可
//注意 mean 是一个整数，所以 n + m 次投掷的总和需要被 n + m 整除。
//示例 1：
//输入：rolls = [3,2,4,3], mean = 4, n = 2
//输出：[6,6]
//解释：所有 n + m 次投掷的平均值是 (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4 。
//示例 2：
//输入：rolls = [1,5,6], mean = 3, n = 4
//输出：[2,3,2,2]
//解释：所有 n + m 次投掷的平均值是 (1 + 5 + 6 + 2 + 3 + 2 + 2) / 7 = 3 。
public class _2028_FindOutTheMissingObservations {
    public static void main(String[] args) {
        int [] rolls = {3,2,4,3};
        int mean = 4;
        int n = 2;
        System.out.println(Method(rolls,mean,n));
    }

    public static int[] Method(int [] nums,int mean,int n) {
        int [] ans = new int[n];
        int count = n+nums.length;
        int total = count * mean;
        int temp = total;
        for (int i = 0; i < nums.length; i++) {//得出丢失值的和
            temp -= nums[i];
        }

        if (temp < n || temp > 6*n){//观察一次，对象的值区间在【1，6】，观察n次，对象的和的区间在【n，n*6】，不在这个区间返回空数组
            return new int[0];
        }
        if (temp >= n && temp <= 6*n) {//在这个区间，设每组平均值为aver，如果i<余数，aver+1，否则就为aver
            int aver = temp/n;
            for (int i = 0; i < n; i++) {
                if (i < temp % n) {
                    ans[i] = aver + 1;
                } else {
                    ans[i] = aver;
                }
            }
        }
        return ans;
    }
}
