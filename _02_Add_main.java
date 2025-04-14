package LeetCode;


public class _02_Add_main extends _02_Add_${
    public static void main (String[] args) {
        int [] nums1 = {2,4,3};
        int [] nums2 = {5,6,4};
        ListNode l1 = setList(nums1);
        ListNode l2 = setList(nums2);
        ListNode p = addTwoNumbers(l1,l2);
        for (int i = 0; i < nums1.length; i++) {
            int num = p.val;
            System.out.println(num);
            p=p.next;
        }

    }
}
