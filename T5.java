package LeetCode;

import java.util.*;
//小 K 有N 项工作，每项工作需要花费ti时间，必须在di时刻或之前完成，报酬为pi
//小 K 从时刻 0 开始工作，同一时刻只能做一项工作，且工作一旦开始不能中断或切换。
// 目标是选择一组工作，使得总报酬最大。
public class T1 {
    static class Job {
        int t, d, p;
        Job(int t, int d, int p) {
            this.t = t;
            this.d = d;
            this.p = p;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 数据组数
        while (T-- > 0) {
            int N = scanner.nextInt(); // 工作数量
            List<Job> jobs = new ArrayList<>();
            int maxDeadline = 0;
            for (int i = 0; i < N; i++) {
                int t = scanner.nextInt();
                int d = scanner.nextInt();
                int p = scanner.nextInt();
                jobs.add(new Job(t, d, p));
                maxDeadline = Math.max(maxDeadline, d);
            }

            // 按照截止时间排序
            jobs.sort(Comparator.comparingInt(j -> j.d));

            // DP 数组，dp[j] 表示时间 j 时的最大报酬
            int[] dp = new int[maxDeadline + 1];
            for (Job job : jobs) {
                // 从后往前更新，避免重复选择
                for (int j = job.d; j >= job.t; j--) {
                    dp[j] = Math.max(dp[j], dp[j - job.t] + job.p);
                }
            }

            // 找出最大值
            int maxProfit = 0;
            for (int j = 0; j <= maxDeadline; j++) {
                maxProfit = Math.max(maxProfit, dp[j]);
            }
            System.out.println(maxProfit);
        }
    }
}