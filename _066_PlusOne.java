package LeetCode;
//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
//最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//你可以假设除了整数 0 之外，这个整数不会以零开头。
//示例 1：
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
//示例 2：
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
//示例 3：
//输入：digits = [0]
//输出：[1]
public class _066_PlusOne {
    public static void main(String[] args) {
        int [] digits = {1,2,3};
        System.out.println(Method(digits));
    }
    public static int [] Method(int[] digits){
        for (int i = digits.length-1; i >= 0 ; i--) {//从末尾遍历，倘若最后一位不是9，就可以进行加一运算
            if (digits[i] != 9){
                digits[i]++;
                return digits;
            }else {//是9的话，就需要向前进一，当前位置变为0
                digits[i] = 0;
            }
        }
        //倘若所有的数字都为9（例如9999），加一运算就需要向前进一变为10000;
        int []temp = new int[digits.length+1];
        temp[0] = 1;
        return temp;
    }
}
