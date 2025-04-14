package LeetCode;
//示例 1：
//输入：s = "abcacb", p = "ab", removable = [3,1,0]
//输出：2
//解释：在移除下标 3 和 1 对应的字符后，"abcacb" 变成 "accb" 。
//"ab" 是 "accb" 的一个子序列。
//如果移除下标 3、1 和 0 对应的字符后，"abcacb" 变成 "ccb" ，那么 "ab" 就不再是 s 的一个子序列。
//因此，最大的 k 是 2 。
//示例 2：
//输入：s = "abcbddddd", p = "abcd", removable = [3,2,1,4,5,6]
//输出：1
//解释：在移除下标 3 对应的字符后，"abcbddddd" 变成 "abcddddd" 。
//"abcd" 是 "abcddddd" 的一个子序列。
public class _1898_TheMaximumNumber {
    public static void main(String[] args) {
        String s = "abcacb";
        String p = "ab";
        int[]removable = {3,1,0};
        System.out.println(Method(s,p,removable));
    }
    public static int Method(String s,String p,int[] removable){
        int left = 0;
        int right = removable.length-1;
        int mid = 0;
        while(left<=right){//从中间开始锁定，当s去除以removable中前mid的值为索引的值
            mid = (left+right)/2;
            if (Method2(s,p,removable,mid)){//判断去除这些字母之后，p还是不是s的子序列
                left=mid+1;
            }else {//不是子序列，就向mid之前缩进
                right=mid-1;//如果不是子序列，就会缩进，而真正的答案，是后一个的值
            }
        }
        return right+1;
    }
    public static boolean Method2(String s,String p, int [] removable, int mid){
        int len1 = s.length();
        int len2 = p.length();
        boolean []judge = new boolean[len1];
        for (int i = 0; i <= mid; i++) {//把s的以removab的值为sy的值打标记，意味着这些打标记的值为已经删除了的，遍历到这个值是不算数的
            judge[removable[i]] = true;
        }
        int j = 0, k =0;
       while(j<len1 && k<len2) {//判断去除这些字母后，还是不是子序列
            if (s.charAt(j) == p.charAt(k) && !judge[j]){//
                k++;
            }
            j++;
       }
       return k == len2;
    }
}
