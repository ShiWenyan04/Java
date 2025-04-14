package LeetCode;

import java.util.Arrays;
//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
//注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
//示例 1：
//输入：nums = [10,2]
//输出："210"
//示例 2：
//输入：nums = [3,30,34,5,9]
//输出："9534330"
public class _0179_Maximum {
    public static void main(String[] args) {
        int [] nums = {0,0};
        System.out.println(Method(nums));
    }
    public static String Method(int[] nums){
//        String[] str = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);//将int【】转化为String【】，相对用在sort里的toString()要慢
        Integer[] str = new Integer[nums.length];
        int j = 0;
        for (int i: nums){
            str [j] = i ;
            j++;
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(str,(a,b)->{//str[] = [3,30,34,5,9]     str1 = 3,str2 = 30      tr1+str2 = 330,str2+str1=303,前者大于后者，所以str1排在str2之前，以此类推
//            sort改写用封装类,即str为Integer,String,Charactor等形式
            String str1 = a.toString();
            String str2 = b.toString();
            return (str2+str1).compareTo(str1+str2);
        });
        if(str[0] == 0){//排序后首位元素为0，说明str[]所有都为0，可组成的最大字符串的首位也是0，实际就是都为0
            return "0";
        }
        for (Integer s : str){//sb连接
            sb.append(s);
        }
        return String.valueOf(sb);
    }
}
