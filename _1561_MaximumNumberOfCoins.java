package LeetCode;

import java.util.Arrays;
//每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。
//Alice 将会取走硬币数量最多的那一堆。
//你将会取走硬币数量第二多的那一堆。
//Bob 将会取走最后一堆。
//重复这个过程，直到没有更多硬币。
public class _1561_MaximumNumberOfCoins {
    public static void main(String [] arg){
        int [] plies = {2,4,1,2,7,8};
        System.out.println(Method(plies));
    }
    public static int Method(int [] piles){//只需让Alice拿到第一多的硬币，我拿到第二多的硬币，而bob不能拿到第三多的硬币，要拿到最少的硬币
        int ans = 0;
        int count = piles.length/3;
        int cnt = 0;
        Arrays.sort(piles);//排序
        for (int i = piles.length-1; i >= 0; i-=2) {//逆序只加第二大的硬币，所以公差为2
            ans+=piles[i-1];
            cnt++;//因为所有硬币平均分，所以分成三堆，如果我拿到三堆，可以直接结束循环
            if(cnt == count){
                break;
            }
        }
        return ans;
    }
}
