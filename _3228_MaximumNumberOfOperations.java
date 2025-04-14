package LeetCode;
//示例 1：
//输入： s = "1001101"
//输出： 4
//解释：
//可以执行以下操作：
//选择下标 i = 0。结果字符串为 s = "0011101"。
//选择下标 i = 4。结果字符串为 s = "0011011"。
//选择下标 i = 3。结果字符串为 s = "0010111"。
//选择下标 i = 2。结果字符串为 s = "0001111"。
//示例 2
//输入： s = "00111"
//输出： 0
public class _3228_MaximumNumberOfOperations {
    public static void main(String[] args) {
        String s ="00111";
        System.out.println(Method(s));
    }
    public static int Method(String s){
        int ans = 0;
        int oper = 0;
        boolean zero = false;
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i) == '0'){//从后往前遍历，如果是0，那么zero = true
                zero =true;
            }else  {//如果是1，zero为真，则需移动，oper+1.
                if (zero){
                    oper ++ ;//每一次间隔有0的1 的oper都是会逐步增长的的
                    zero = false;
                }
                ans+=oper;//ans记录总操作数
            }
        }
        return ans;
    }
}
