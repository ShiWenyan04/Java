package LeetCode;
import java.util.*;
//两个非空链表，表示两个非负整数。他们每位数字都是按照 逆序 的方式存储，并且每个节点只能存储 一位 数字。
//
//请您将两个数相加，并以相同形式返回一个表示和的链表
//
//你可以假设除了数字0之外，这两个数都不会以 0 开头。
//
//输入：L1=[2，4，3]，L2=[5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807

public class _02_Add_$ {
    public static class ListNode {
        int val;          // 节点的值
        ListNode next;    // 指向下一个节点的引用（指针）

        // 默认构造函数，创建一个没有值和指向下一个节点的节点
        ListNode() {}

        // 构造函数，创建一个值为 val 的节点，next 默认为 null
        ListNode(int val) {
            this.val = val;
        }

        // 构造函数，创建一个值为 val 且指向下一个节点的节点
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode setList(int[] nums){
        int i = 0;
        ListNode p = null,n,first = null;
        while (i < nums.length) {
            if (i == 0){
                n = new ListNode(nums[i]);
                first = n;
                p = n ;
                i++;
                continue;
            }
            n = new ListNode(nums[i]);
            p.next = n;
            p = p.next;
            i++;
        }
        return first;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int carry = 0;
        int sum = 0;
        ListNode head = null,tail = null;
        while(l1!=null||l2!=null){
            int n1 = 0,n2 = 0;
            if(l1==null){
                n1 = 0;
            }else {
                n1 = l1.val;
            }
            if(l2 == null){
                n2 = 0;
            }else{
                n2 = l2.val;
            }
            sum = (n1+n2)+carry;
            if(head == null){
                head = tail = new ListNode(sum%10);
            }else{
                tail.next = new ListNode(sum%10);
                tail=tail.next;
            }
            carry = sum/10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}

