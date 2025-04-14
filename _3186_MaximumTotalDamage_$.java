package LeetCode;

import java.util.*;

//已知魔法师使用伤害值为 power[i] 的咒语时，他们就 不能 使用伤害为 power[i] - 2 ，power[i] - 1 ，power[i] + 1 或者 power[i] + 2 的咒语。
//输入：power = [1,1,3,4]
//输出：6
//解释：
//可以使用咒语 0，1，3，伤害值分别为 1，1，4，总伤害值为 6 。
//示例 2：
//输入：power = [7,1,6,6]
//输出：13
//解释：
//可以使用咒语 1，2，3，伤害值分别为 1，6，6，总伤害值为 13 。
public class _3186_MaximumTotalDamage_$ {
    public static void main(String[] args) {
        int [] power = {7,1,6,6};
        System.out.println(Method(power));
    }
    public static long Method(int [] power){
        HashMap<Long,Long> hashMap = new HashMap<>();
        for (int i : power){
            hashMap.put((long)i,hashMap.getOrDefault((long)i,0l)+(long)i);//相同聚集
        }
        List<Map.Entry<Long,Long>> list = new ArrayList<>(hashMap.entrySet());//创建新的数组
        Collections.sort(list, Map.Entry.comparingByKey());//按照伤害值排序

        long [] f = new long[hashMap.size()];
        f[0] = list.get(0).getValue();

        for (int i = 1; i < list.size(); i++) {
            f[i] = f[i-1];// 假设不选 arr[i]
            int j = i-1;
            while(j >= 0 && list.get(j).getKey() >= list.get(i).getKey()-2){
                j--;
            }
            if (j >= 0){
                f[i] = Math.max(f[i],f[j]+list.get(i).getValue());
            }else {
                f[i] = Math.max(f[i],list.get(i).getValue());
            }
        }
        return f[list.size()-1];
    }
}
