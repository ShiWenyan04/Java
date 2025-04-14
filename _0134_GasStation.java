package LeetCode;
//在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
//示例 1:
//输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//输出: 3
//示例 2:
//
//输入: gas = [2,3,4], cost = [3,4,3]
//输出: -1
public class _0134_GasStation {
    public static void main(String[] args) {
        int []gas = {5,1,2,3,4};
        int []cost = {4,4,1,5,1};
        System.out.println(Method(gas,cost));
    }
    public static int Method(int [] gas , int [] cost){
        int ans = -1;
        int re = 0;
        int visited = 0;
//        先确保加油站总共加的油足够消耗
        int total1 = 0,total2 = 0;
        for (int i = 0; i < gas.length; i++) {
            total1 += gas[i];
            total2 += cost[i];
        }
        if (total1 < total2){
            return -1;
        }
//        进行判定，首先可以将两个数组变成两倍长
        int times = 0;
        for (int i = 0; i < gas.length*2; i++) {
            if(gas [i % gas.length] + re >= cost[i % gas.length]){//油箱内的残余＋新加的油是能够支撑前往下一个站点
                re = re + gas[i % gas.length] - cost[i % gas.length];
                visited = i % gas.length;
                times ++;
            }else if(gas [i % gas.length] + re <= cost[i % gas.length] && i != 0){//油箱内的残余＋新加的油不能够支撑前往下一个站点
                re = 0;
                i = visited;
                times = 0;
                visited++;
            }
            if(times == gas.length){//刚好绕一圈，结束返回答案
                ans = (i+1)%gas.length;
                break;
            }
        }
        return ans;
    }
}
