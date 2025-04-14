package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _373_kSmallestPairs {
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        System.out.println(Method(nums1, nums2, k));
    }

    public static List<List<Integer>> Method(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        List<List<Integer>> ans = new ArrayList<>(k);
        PriorityQueue<int []> pre = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for (int i = 0; i < Math.min(k,m); i++) {
            pre.offer(new int[]{nums1[i]+nums2[0],i,0});
        }
        while(ans.size() < k){
            int [] p = pre.poll();
            int i = p[1];
            int j = p[2];
            ans.add(Arrays.asList(nums1[i],nums2[j]));
            if(j+1 < n){
                pre.offer(new int[]{nums1[i]+nums2[j+1],i,j+1});
            }
        }

        return ans;
    }
} 