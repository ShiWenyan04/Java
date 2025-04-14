package LeetCode;


public class _1980_findDifferentBinaryString {
    public static void main(String[] args) {
        String  []nums = {"111","011","001"};
        System.out.println(Method(nums));
    }
    public static String Method(String [] nums ){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i].charAt(i) == '0') sb.append(1);
            else sb.append(0);
        }
        return sb.toString();
    }
}
